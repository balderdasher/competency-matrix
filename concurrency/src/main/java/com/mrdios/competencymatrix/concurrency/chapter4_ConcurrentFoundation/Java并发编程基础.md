> 线程作为操作系统调度的最小单元，多个线程能够同时执行，这将显著提升程序的性能，在多核环境中表现更加明显。但是过多地创建线程和对线程的不当管理也容易造成问题。本章介绍的是Java并发编程的一些基础知识。

## 4.1 线程简介 ##

> 现在操作系统在运行一个程序时，会为其创建一个进程（process）。例如启动一个Java程序，操作系统就会创建一个Java进程。线程是现代操作系统调度的最小单元，所以线程也叫作`轻量级进程(LightWeightProcess)`在一个进程中可以创建多个线程，这些线程都拥有各自的`计数器`、`堆栈`和`局部变量`等属性，并且能够访问共享的内存变量。处理器在这些线程上高速切换，让使用者感觉到这些线程是同时在执行。


Java程序天生就是多线程程序，比如一个从`main()`方法开始执行的Java程序看似没有其他线程参与，但是此时执行的main()就是一个名为`main`的线程，下面是使用`JMX`查看普通Java程序的结果：

```java
/**
 * 用JMX查看普通的Java程序所包含的线程
 * @author MrDios
 * @date 2017-06-12
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的监视器(monitor)和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
```

本机输出说明：

```java
[10]Monitor Ctrl-Break; // windows环境中支持控制台Ctrl-Break获取线程dump的线程（结合网络个人翻译）
[5]Attach Listener;     // 进程间通信监听的线程（结合网络个人翻译）
[4]Signal Dispatcher;   // 分发处理发送给JVM信号的线程
[3]Finalizer;           // 调用对象finalize方法的线程
[2]Reference Handler;   // 清除reference的线程
[1]main                 // main线程，用户程序入口
```
原来除了main（）方法在执行，还有多个其他线程同时执行。

### 4.1.1 为什么要用多线程 ###

上面一个简单得像“Hello World”的程序居然有那么多线程在运行，为啥不直接一个线程就好了呢，我也不知道为啥，书上说了：这样有好处。有什么好处？

- 更多的处理器核心
- 更快的响应时间
- 更好的编程模型

### 4.1.2 线程的状态 ###

状态名|说明
---|---
NEW|**初始状态**，线程被构建，但还没调用`start()`方法
RUNNABLE|**运行状态**，Java线程将操作系统中的就绪和运行两种状态笼统地称为“运行中”
BLOCKED|**阻塞状态**，表示线程阻塞于锁
WAITING|**等待状态**，表示线程进入等待状态，进入该状态表示当前线程需要等待其他线程做出一些特定动作（通知或中断）
TIME_WAITING|**超时等待状态**，不同于WAITING，此状态可以在指定时间自行返回
TERMINATED|**终止状态**，表示当前线程已经执行完毕

#### 使用jstack查看线程的dump信息 ####

1. 运行程序，在命令行中输入命令`jps`用于查看正在运行的进程ID`pid`
  ```cmd
  C:\Users\mrdios>jps
28560 Launcher
10276
13100 RemoteMavenServer
25004 AppMain
28652 Jps
  ```
2.使用命令`jstack pid`查看正在运行的线程信息（pid与第一步中的进程id一致）

## 4.2 线程的启动和终止 ##

### 4.2.1 理解中断 ###

> 中断可以理解为线程的一个标识位属性，它表示一个运行中的线程是否被其他线程进行了中断操作。中断好比其他线程对该线程打了个招呼，其他线程通过调用该线程的`interrupt()`方法对其进行中断操作。

线程通过方法`isInterrupted()`来进行判断自身是否被中断，也可以调用静态方法`Thread.interrupted()`对当前线程的中断标识位进行复位。如果该线程已经处于终结状态，即使该线程被中断过，在调用该线程对象的`isInterrupted()`时依旧会返回`false`。

Java的api中，许多声明抛出`InterruptedException`的方法在抛出`InterruptedException`之前，JVM会先将该线程的中断标识位清除，然后抛出InterruptedException，此时调用`isInterrupted()`方法将返回`false`。如下面的例子所示：

```java
public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread不停地尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        // busyThread不停地运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        // 启动线程
        sleepThread.start();
        busyThread.start();

        // 休眠5s，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);

        // 中断线程
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        // 防止sleepThread和busyThread立刻退出
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                // do nothing
            }
        }
    }
}
```

输出：

```java
SleepThread interrupted is false
java.lang.InterruptedException: sleep interrupted
BusyThread interrupted is true
	at java.lang.Thread.sleep(Native Method)
	at java.lang.Thread.sleep(Thread.java:340)
	at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
	at com.mrdios.competencymatrix.concurrency.util.SleepUtils.second(SleepUtils.java:12)
	at com.mrdios.competencymatrix.concurrency.chapter4_ConcurrentFoundation.Interrupted$SleepRunner.run(Interrupted.java:43)
	at java.lang.Thread.run(Thread.java:745)
```

输出结果可以看出，抛出`InterruptedException`的线程`SleepThread`的中断标识位被清除了，而一直忙碌的线程`BusyThread`的中断标识位没有被清除。

### 4.2.2 过期的方法 ###

在Java的Thread Api中，`suspend()`、`resume()`和`stop()`方法是过期的，不推荐使用（暂停和恢复等操作使用等待/通知机制来代替）。原因是：

- `suspend()`方法在调用后线程不会释放已经占有的资源（比如锁），而是占用着资源进入睡眠状态，这样容易引发死锁问题。
- `stop()`方法在终结一个线程时不会保证线程的资源正常释放，通常是没有给予线程完成资源释放工作的机会，因此会导致程序可能工作在不确定的状态下。

### 4.2.3 安全地终止线程 ###

使用标识位或中断操作的方式能够使线程在终止时有机会去干别的事（清理资源等），而不是武断地将线程停止，这样显得更加安全和优雅。

```java
/**
 * 通过标识位或中断操作安全地终止线程
 *
 * @author MrDios
 * @date 2017-06-13
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Runner r1 = new Runner();
        Thread countThread = new Thread(r1, "CountThread");
        countThread.start();
        // 睡眠1s，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner r2 = new Runner();
        countThread = new Thread(r2, "CountThread");
        countThread.start();
        // 睡眠1s，main线程对Runner r2进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        r2.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true; // 标识位

        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
```

## 4.3 线程间通信 ##

### 4.3.1 等待/通知机制 ###

> 等待/通知机制，是指一个线程`A`调用了对象`O`的`wait()`进入等待状态，而另一个线程`B`调用了对象`O`的`notify()`或者`notifyAll()`方法，线程`A`收到通知后从对象`O`的`wait()`方法返回，进而执行后续操作。上述两个线程通过对象`O`来完成交互，而对象上的`wait()`和`notify/nofityAll()`的关系就如同开关信号一样，用来完成等待方和通知方之间的交互工作。

等待/通知的相关方法

方法名称|描述
---|---
notify()|通知一个在对象上等待的线程，使其从`wait()`方法返回，而返回的前提是该线程获取到了对象的锁
notifyAll()|通知所有等待在该对象上的线程
wait()|调用该方法的线程进入`WAITING`状态，只有等待另外线程的通知或被中断才会返回，需要注意，调用`wait()`方法后，会释放对象的锁
wait(long)|超时等待一段时间，参数时间是毫秒，即等待长达n毫秒，如果没有通知就超时返回
wait(long,int)|对于超时时间更细粒度的控制，可以达到纳秒

例子：

```java
/**
 * 等待/通知机制
 *
 * @author MrDios
 * @date 2017-06-13
 */
public class WaitNofity {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通信，通知时不会释放lock的锁
                // 直到当前线程释放了lock后，WaitThread才能从wait方法返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
```
输出：

> Thread[WaitThread,5,main] flag is true. wait@ 15:06:28
Thread[NotifyThread,5,main] hold lock. notify @ 15:06:29
Thread[NotifyThread,5,main] hold lock again. sleep@15:06:34
Thread[WaitThread,5,main] flag is false. running@ 15:06:39

以上例子演示了等待/通知的机制，`WaitThread`检查`flag`是否为false，若是则进行后续操作，否则在`lock`上等待，`NotifyThread`在睡眠了一段时间之后对`lock`进行通知。

调用`wait()`、`notify()`及`notifyAll()`时需要注意以下几点：

- 使用`wait()`、`notify()`和`notifyAll()`时需要先获得对象的锁
- 调用`wait()`后，线程状态由`RUNNING`变为`WAITING`，并将当前线程放置到对象的等待队列
- `notify()`或`notifyAll()`方法调用后，等待线程依旧不会从`wait()`返回，需要调用`notify()`或`notifyAll()`的线程释放锁之后，等待线程才有机会从`wait()`返回
- `notify()`方法将等待队列中的一个等待线程从等待队列中移到同步队列中，而`notifyAll()`方法则将等待队列中所有的线程全部移到同步队列，被移动的线程状态由`WAITING`变为`BLOCKED`
- 从`wait()`方法返回的前提是获得了调用对象的锁

#### 等待/通知的经典范式 ####

其实就是`生产者-消费者`模型，此范式分为两部分，分别针对等待方（消费者）和通知方（生产者）。

等待方（消费者）遵循以下原则：

- 获取对象的锁
- 如果条件不满足，那么调用对象的`wait()`方法，被通知后仍要检查条件
- 条件满足则执行对应的逻辑

伪代码

```java
synchronized(对象) {
	while(条件不满足) {
		对象.wait();
	}
	对应的处理逻辑
}
```

通知方（生产者）遵循以下原则：

- 获得对象的锁
- 改变条件
- 通知所有等待在对象上的线程

伪代码：

```java
synchronized(对象) {
	改变条件
	对象.notifyAll();
}
```

### 4.3.2 Thread.join()的使用 ###

> 在一个线程`ta`中执行了`tb.join()`语句，其含义是：当前线程`ta`等待`tb`线程终止之后才从`tb.join()`返回。线程除了提供`join()`方法外，还提供了`join(long millis)`和`join(long millis,int nanos)`两个具备超时特性的方法。这两个方法表示如果线程`thread`在给定的超时时间里没有终止，那么将会从该超时方法中返回

实例演示：

```java
/**
 * Thread.join()的使用
 *
 * @author MrDios
 * @date 2017-06-14
 */
public class Join {
    public static void main(String[] args) {
        final Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                SleepUtils.second(5);
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(new Date());
                try {
                    a.join();               // 1
                    //a.join(2000);       // 2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        });

        a.start();
        b.start();
    }
}
```
输出：

> Wed Jun 14 12:52:45 CST 2017
Wed Jun 14 12:52:50 CST 2017

注释掉1，放开注释2，此时输出：

> Wed Jun 14 12:54:00 CST 2017
Wed Jun 14 12:54:02 CST 2017

可以看出，加入了超时时间之后，因为超时时间小于线程`a`的执行时间，所以没等`a`睡够，`b`就从`a.join()`返回了。

这里有个疑问：如果设置的超时时间大于a的执行时间，效果会是什么样的呢，于是我做了个实验，把超时时间设为`8000`，发现此时的输出和不设置超时时间的时候性质一样，这说明了如果超时时间大于`join`进来的线程`a`的执行时间，那么此时只要`a`执行完毕终止了就立即返回（貌似挺人性化的，就好像某个哥们一有钱就把钱还了不用等到约定的还债日期一样）。

### 4.3.3 ThreadLocal的使用 ###

> `ThreadLocal`，也叫线程变量，是一个以`ThreadLocal`对象为键，任意对象为值的存储结构。此结构被附带在线程上，也就是说一个线程可以根据一个`ThreadLocal`对象查询到绑定在这个线程上的一个值。
> 可以通过`set(T)`方法来设置值，在当前线程下再通过`get()`方法获取到原来设置的值。

示例：

```java
/**
 * ThreadLocal的使用
 *
 * @author MrDios
 * @date 2017-06-14
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    // 返回从begin()方法调用开始到end()方法被调用时的时间差
    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " millis");
    }
}
```
输出：

> Cost: 1002 millis

以上的类可用于调用耗时的统计功能上，在方法入口前执行`begin()`方法，调用方法之后执行`end()`方法。

