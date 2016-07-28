package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter21;

/**
 * 线程加入（join）
 *
 * @author mrdios
 * @date 2016-07-28 17:42
 */
class Hide extends Thread {
    private int duration;

    public Hide(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted " + "isInterrupted(): " + isInterrupted());
            return;
        }
        System.out.println(getName() + " has hided");
    }
}

class Seek extends Thread {
    private Hide child;

    public Seek(String name, Hide child) {
        super(name);
        this.child = child;
        start();
    }

    @Override
    public void run() {
        try {
            child.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(child.getName() + " has hided and " + getName() + " can go get him");
    }
}

public class HideAndSeek {
    public static void main(String[] args) {
        Hide
                tom = new Hide("tom", 1500),
                jack = new Hide("jack", 1500);
        Seek
                dad = new Seek("dad", tom),
                mom = new Seek("mom", jack);
//        jack.interrupt();
    }
}
