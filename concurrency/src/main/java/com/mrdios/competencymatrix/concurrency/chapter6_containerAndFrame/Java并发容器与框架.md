## 6.1 ConcurrentHashMap的实现原理与使用 ##

> `ConcurrentHashMap`是线程安全并且高效的`HashMap`,那么它是如何在保证线程安全的同时又能保证高效的操作的呢？

### 6.1.1 为什么要使用ConcurrentHashMap ###

在并发编程时使用`HashMap`可能导致程序死循环，使用`HashTable`效率又很低下，基于以上原因，在并发编程时通常我们使用`ConcurrentHashMap`。

**HashMap是线程不安全的**

为什么说`HashMap`是线程不安全的呢，因为在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%，所以并发情况下不能使用HashMap。如以下代码所示(本机测试并没有效果CPU利用率在70%左右，难道改进了？)：

```java
public class NotThreadSafeHashMap {
    public static void test() throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }

                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
```

HashMap在并发执行put操作时会引起死循环，是因为多线程会导致`HashMap`的`Entry`链表形成环形数据结构，一旦形成环形数据结构，`Entry的next节点`永远不为空，就会产生死循环获取`Entry`>

**效率低下的HashTable**

HashTable容器使用`synchronized`来保证线程安全，但在竞争激烈时`HashTable`的效率非常低下，因为当一个线程访问`HashTable`的同步方法，其他线程也访问它的同步方法时，会进入阻塞或轮询状态，如线程1使用put进行添加元素，线程2不但不能使用put方法，也不能使用`get`方法来获取元素，所以竞争越激烈效率越低。

**ConcurrentHashMap的锁分段技术可以有效提升并发效率**

HashTable容器在竞争激烈时表现出效率低下的原因是所有访问`HashTable`的线程都必须竞争同一把锁，假如容器里有多把锁，每一把用于锁容器中的一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，从而提高并发访问效率。这就是`ConcurrentHashMap`使用的`锁分段`技术。首先将数据分成一段一段地存储，然后每一段数据配一把锁，当一个线程占用锁访问其中一段数据的时候，其他段的数据也能被其他线程访问。