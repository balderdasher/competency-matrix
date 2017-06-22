> 当程序更新一个变量时，如果多个线程同时更新这个变量，可能得到期望之外的值，比如变量`i=1`,A线程更新`i+1`，B线程也更新`i+1`，经过两个线程操作之后可能i不等于3而是等于2,。因为A和B线程在更新变量i的时候拿到的i都是1，这就是线程不安全的更新操作，通常使用`synchronized`来解决这个问题，`synchronized`会保证多线程不会同时更新变量i。

从`JDK1.5`开始，Java提供了`java.util.concurrent.atomic`包，这个包中的原子操作类提供了一种用法简单、性能高效、线程安全地更新一个变量的方式。

在`Atomic`包中一共提供了13个类，属于4中类型的原子更新方式，分别是**原子更新基本类型**、**原子更新数组**、**原子更新引用**和**原子更新属性(字段)**。Atomic包中的类基本都是使用`Unsafe`实现的包装类。

## 7.1 原子更新基本类型 ##

Atomic包中提供了以下3个类用于原子更新基本类型：

- `AtomicBoolean`：原子更新布尔类型
- `AtomicInteger`：原子更新整形
- `AtomicLong`：原子更新长整型

以上3个类提供的方法几乎一样，此处以`AtomicInteger`类进行举例，`AtomicInteger`的常用方法如下：

方法|描述
---|---
int addAndGet(int delta)|以原子方式将输入的数值与实例中的值(AtomicInteger里的value)相加，并返回结果
boolean compareAndSet(int expect,int update)|如果输入的数值等于预期值，则以原子方式将该值设置为输入的值
int getAndIncrement()|以原子方式将当前值加1，注意：**这里返回的是自增前的值**
void lazySet(int newValue)|最终设置成`newValue`,使用lazySet设置值后，可能导致其他线程在之后一小段时间内还是读到旧的值，详情参考[《AtomicLong.lazySet是如何工作的》](http://ifeve.com/how-does-atomiclong-lazyset-work/ "《AtomicLong.lazySet是如何工作的》")
int getAndSet(int newValue)|以原子方式设置为`newValue`的值，并返回旧值

getAndIncrement是如何实现原子操作的呢，来看下源码：

```java
public final int getAndIncrement() {
	for (;;) {
		int current = get();
		int next = current + 1;
		if (compareAndSet(current, next))
			return current;
	}
} 
public final boolean compareAndSet(int expect, int update) {
	return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
}
```

源码中`for`循环体的第一步先取得`AtomicInteger`里存储的数值，第二步对`AtomicInteger`的当前数值进行加1操作，关键的第三步调用`compareAndSet`方法来进行原子更新操作，该方法先检查当前数值是否等于`current`，意味着`AtomicInteger`的值没有被其他线程修改过，则将`AtomicInteger`的当前数值更新成`next`的值，如果不等`compareAndSet`方法会返回false,程序会进入for循环重新进行compareAndSet操作。

## 7.2 原子更新数组 ##

Atomic包提供以下3个类来通过原子方式更新数组里的某个元素：

1. AtomicIntegerArray：原子更新整型数组里的元素
2. AtomicLongArray：原子更新长整型数组里的元素
3. AtomicReferenceArray：原子更新引用类型数组里的元素

以上几个类提供的方法几乎一样，此处以`AtomicIntegerArray`举例：

AtomicIntegerArray类主要提供原子方式更新数组里的整型，常用方法如下：

- `int addAndGet(int i,int delta)`:以原子方式将输入值与数组中索引`i`的元素相加
- `boolean compareAndSet(int i, int expect, int update)`：如果当前值等于预期值，则以原子方式将数组位置`i`的元素设置成`update`值

```java
public class AtomicIntegerArrayTest {
    static final int[] value = {1, 2};
    static final AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
```

输出：

> 3
> 1

从输出可以看出，数组`value`通过构造方法传递给`AtomicIntegerArray`，AtomicIntegerArray会将当前数组复制一份，所以当AtomicIntegerArray对内部的数组元素进行修改时，不会影响传入的数组。

## 7.3 原子更新引用类型 ##

Atomic包提供3个类用于原子更新引用类型：

1. AtomicReference:原子更新引用类型
2. AtomICReferenceFieldUpdater：原子更新引用类型里的字段
3. AtomicMarkableReference：原子更新带有标记位的引用类型，可以原子更新一个布尔类型的标记位和引用类型，构造方法是`AtomICMarkableReference(V initialRef,boolean initialMark)`。

因为几个类提供的方法几乎一样，以`AtomicReference`举例：

```java
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tom", 15);
        atomicUserRef.set(user);
        System.out.println(atomicUserRef.get());
        User updateUser = new User("jerry", 17);
        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get());
        System.out.println(user);
    }

    static class User {
        private String name;
        private int oid;

        public User(String name, int oid) {
            this.name = name;
            this.oid = oid;
        }

        public String getName() {
            return name;
        }

        public int getOid() {
            return oid;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", oid=" + oid +
                    '}';
        }
    }
}
```

输出：

> User{name='tom', oid=15}
User{name='jerry', oid=17}
User{name='tom', oid=15}

第三行的输出一开始让我困惑，仔细一想，原子更新引用类型更新的是`AtomicReference`中保存的引用`V`，这个引用可以指向tom，也可以修改为指向Jerry，并不是把user的引用修改为指向Jerry，`user`和`updateUser`本身的引用并没有改变。所以才会有此输出。

## 7.4 原子更新字段类 ##

原子更新字段类用于更新某个类里的某个字段，`Atomic`包提供以下3个类用于进行原子字段更新：

1. AtomicIntegerFieldUpdater：原子更新整型的字段的更新器
2. AtomicLongFieldUpdater：原子更新长整型字段的更新器
3. AtomicStampedeReference：原子更新带有版本号的引用类型。该类型将整数值与引用关联起来，可用于原子地更新数据和数据的版本号，可以解决使用`CAS`进行原子更新时可能出现的`ABA`问题。

原子更新字段分为两个步骤：

1. 第一步，因为原子更新字段类都是抽象类，每次使用必须使用静态方法`newUpdater()`创建一个更新器，并且需要设置想要更新的类和属性
2. 第二步，更新类的字段（属性）必须使用`public volatile`修饰

下面以`AtomicIntegerFieldUpdater`类为例说明原子更新字段类的使用：

```java
/**
 * 原子更新字段类的使用
 *
 * @author MrDios
 * @date 2017-06-22
 */
public class AtomicIntegerFieldUpdaterTest {
    // 创建原子更新器，并设置要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "oid");

    public static void main(String[] args) {
        User tom = new User("tom", 10);
        // 按照之前的设置原子更新对象的字段
        System.out.println(a.getAndIncrement(tom));
        System.out.println(a.get(tom));
    }

    public static class User {
        private String name;
        public volatile int oid;

        public User(String name, int oid) {
            this.name = name;
            this.oid = oid;
        }

        public String getName() {
            return name;
        }

        public int getOid() {
            return oid;
        }
    }
}
```

输出：

> 10
> 11

