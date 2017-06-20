本章来学习：Java中的锁到底是个什么玩意。

## 5.1 Lock接口 ##

> 锁是用来控制多个线程访问共享资源的方式，一个锁能防止多个线程同时访问共享资源（读写锁等可以允许多个线程并发访问共享资源），`Lock`接口出现之前，Java是靠`synchronized`关键字实现锁功能的，Java SE 5之后新增了Lock接口。它提供了与`synchronized`关键字类似的同步功能，只是在使用时需要显式地获取和释放锁，虽然缺少了`synchronized`方式的隐式获取和释放锁的便捷性，但是也有用了锁获取和释放的可操作性、可中断的获取锁以及超时获取锁等多种`synchronized`关键字所不具备的同步特性。

Lock的使用很简单，如下所示：

```java
Lock lock = new ReentrantLock();
lock.lock();            // 锁住
try {
    // doSomething
} finally {
    lock.unlock();      // 释放锁
}
```

注意：

- 不要将获取锁的过程写在`try`块中，因为如果在获取锁时发生异常，异常抛出的同时，也会导致锁无故释放。
- 在`finally`块中释放锁，目的是保证在获取到锁之后，最终能够被释放。

Lock接口有一些`synchronized`关键字所不具备的特性，如下表：

特性|描述
---|---
尝试非阻塞地获取锁|当前线程尝试获取锁，如果这一时刻锁没有被其他线程获取到，则成功获取并持有锁
能被中断地获取锁|与`synchronized`不同，获取到锁的线程能够相应中断，当获取到锁的线程被中断时，中断异常将被抛出，同时锁会被释放
超时获取锁|在指定的截止时间之前获取锁，如果截止时间到哦仍旧无法获取锁，则返回

Lock接口定义了获取和释放锁的基本操作，API如下所示：

方法名称|描述
---|---
void lock()|获取锁，调用该方法当前线程将会获取锁，当获得锁后从该方法返回
void lockInterruptibly() throws InterruptedException|可中断地获取锁，和`lock()`不同之处在于该方法会响应中断，即在锁的获取中可以中断当前线程
boolean tryLock()|尝试非阻塞的获取锁，调用该方法后立刻返回，如果能够获取则返回`true`，否则返回`false`
boolean tryLock(long time,TimeUnit unit) throws InterruptedException|超时获取锁，当前线程在以下3中情况下会返回<br>1. 当前线程在超时时间内获得了锁<br>2. 当前线程在超时时间<br>3. 超时时间结束，返回`false`
void unlock()|释放锁
Condition newCondition()|获取等待通知组件，该组件和当前的锁绑定，当前线程只有获得了锁，才能调用该组件的`wait()`方法，而调用后，当前线程将释放锁



## 5.2 队列同步器 ##

> 队列同步器`AbstractQueuedSynchronizer`（简称同步器），是用来构建锁或者其他同步组件的基础框架，使用了一个`int`成员变量来表示同步状态，通过内置的`FIFO`队列来完成资源获取线程的排队工作。

同步器是实现锁的关键。锁是面向使用者的，它定义了使用者与锁交互的接口，隐藏了实现细节；同步器是面向锁的实现者，它简化了锁的实现方式，屏蔽了同步状态管理、线程的排队、等待与唤醒等底层操作。

同步器提供的模板方法基本上分为三类：独占式获取与释放同步状态、共享式获取与释放同步状态和查询同步队列中的等待线程情况。自定义同步组件将使用同步器提供的模板方法来实现自己的同步语义，如以下代码所示：

```java
/**
 * 自定义同步器组件
 * @author MrDios
 * @date 2017-06-20
 */
public class Mutex implements Lock {

    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer{
        // 是否处于占用状态
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }
        // 当状态为0时获取锁
        public boolean tryAcquire(int acquires){
            if (compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放锁，将状态设置为0
        protected boolean tryRelease(int releases){
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        // 返回一个Condition，每个Condition都包含一个condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    // 仅需要将操作代理到Sync上即可
    private final Sync sync = new Sync();
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
```

## 5.3 重入锁 ##

> 重入锁`ReentranLock`，顾名思义就是支持重新进入的锁，它表示该锁能够支持一个线程对资源的重复加锁，除此之外，该锁还支持获取锁时的公平和非公平性选择。

获取锁的公平性问题表示：如果在绝对时间上，先对锁进行获取的请求一定先被满足，那么这个锁是公平的，反之则是不公平的。公平的获取锁，也就是等待时间最长的线程最优先获取锁，也可以说锁获取是顺序的，`ReentranLock`提供了一个构造函数，能够控制锁是否是公平的。

### 5.3.1 重入的实现 ###

重进入是指任意线程在获取到锁之后能再次获取该锁而不会被锁阻塞，要实现该特性需要解决以下两个问题：

- **线程再次获取锁**：锁需要去识别获取锁的线程是否为当前占据锁的线程，如果是，则再次成功获取。
- **锁的最终释放**：线程重复`n`次获取了锁，随后在第`n`此释放该锁后，其他线程能够获取到该锁，锁的最终释放要求锁对于获取进行计数自增，计数表示当前锁被重复获取的次数，而锁被释放时，计数自减，当计数等于0时表示锁已经成功释放。

ReentranLock中对应的实现如下：

```java
final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        if (compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}

protected final boolean tryRelease(int releases) {
    int c = getState() - releases;
    if (Thread.currentThread() != getExclusiveOwnerThread())
        throw new IllegalMonitorStateException();
    boolean free = false;
    if (c == 0) {
        free = true;
        setExclusiveOwnerThread(null);
    }
    setState(c);
    return free;
}
```

### 5.3.2 公平与非公平获取锁的区别 ###

非公平性锁可能使线程“饥饿”，为什么反而被设定成默认的实现呢，因为实验证明非公平性锁的开销更小，公平性锁保证了锁的获取按照`FIFO`原则，而代价是进行大量的线程切换。非公平性锁虽然可能造成线程“饥饿”，但极少的线程切换，保证了更大的吞吐量。

## 5.4 读写锁 ##

> 和排他锁不同，读写锁在同一时刻可以允许多个读线程访问，但是在写线程访问时，所有的读线程和其他写线程均被阻塞。读写锁维护了一对锁，一个读锁和一个写锁，通过分离读锁和写锁，使得并发性相比一般的排他锁有了很大提升。

Java并发包提供读写锁的实现是`ReentrantReadWriteLock`,特性如下表：

特性|说明
---|---
公平性选择|支持非公平（默认）和公平的锁获取方式，吞吐量还是非公平优于公平
重进入|该锁支持重进入，以读写线程为例：读线程在获取了读锁之后，能够再次获取读锁；写线程在获取了写锁之后能够再次获取写锁，同时也可以获取读锁
锁降级|遵循获取写锁、获取读锁再释放写锁的顺序，写锁能够降级成读锁

下面是一个缓存示例说明读写锁的使用方式：

```java
/**
 * 读写锁使用示例
 *
 * @author MrDios
 * @date 2017-06-20
 */
public class Cache {
    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    // 获取缓存
    public static final Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    // 设置缓存
    public static final Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    // 清空缓存
    public static final void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
```

## 5.5 Condition接口 ##

> 任一Java对象都有一组监视器方法（定义在`java.lang.Object`上），主要包括`wait()`、`wait(long timeout)`、`notify()`和`notifyAll()`方法，这些方法与`synchronized`同步关键字配合，可以实现等待/通知模式。`Condition`接口也提供了类似`Object`的监视器方法，与`Lock`配合可以实现等待/通知模式，两者对比如下表：

对比项|Object Monitor Methods|Condition
---|---|---
前置条件|获取对象的锁|调用`Lock.lock()获取锁`<br>调用`Lock.newCondition()`获取Condition对象
调用方式|直接调用如：`object.wait()`|直接调用如：`condition.await()`
等待队列个数|一个|多个
当前线程释放锁并进入等待状态|支持|支持
当前线程释放锁并进入等待状态，在等待状态中不响应中断|不支持|支持
当前线程释放锁并进入超时等待状态|支持|支持
当前线程释放锁并进入等待状态到将来的某个时间|不支持|支持
唤醒等待队列中的一个线程|支持|支持
唤醒等待队列中的全部线程|支持|支持

### 接口示例 ###

```java
/**
 * Condition接口示例
 *
 * @author MrDios
 * @date 2017-06-20
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
```

如以上代码所示，`Condition`定义了等待/通知两种类型的方法，当前线程调用这些方法时，需要提前获取到`Condition`对象关联的锁，Condition对象是由Lock对象创建出来的，所以说Condition是依赖Lock对象的。

一般都会将`Condition`对象作为成员变量，当调用`await`方法后，当前线程会释放锁并在此等待，而其他线程调用`Condition`对象的`signal()`方法，通知当前线程后，当前线程才从`await()`方法返回，并且在返回之前已经获取了锁。

以下是一个用`Condition`接口实现的有界队列示例：

```java
/**
 * 使用Condition接口实现的有界队列
 *
 * @author MrDios
 * @date 2017-06-20
 */
public class BoundedQueue<E> {
    private E[] items;      // 队列中的元素
    private int addIndex;   // 插入元素的下标
    private int removeIndex;// 删除元素的下标
    private int count;      // 队列中的元素数量

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();   // 队列不空的条件
    private Condition notFull = lock.newCondition();    // 队列不满的条件

    public BoundedQueue(int size) {
        items = (E[]) new Object[size];
    }

    /**
     * 添加元素：如果数组满，则添加线程进入等待状态，知道有“空位”
     *
     * @param e element
     * @throws InterruptedException
     */
    public void add(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[addIndex] = e;
            if (++addIndex == items.length) {
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 由头部删除一个元素，如果数组为空，则删除线程进入等待状态，知道有新元素被添加
     *
     * @return the element removed
     * @throws InterruptedException
     */
    public E remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            E x = items[removeIndex];
            if (++removeIndex == items.length) {
                removeIndex = 0;
            }
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
```



