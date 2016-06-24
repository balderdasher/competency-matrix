package com.mrdios.competencymatrix.test.java.JavaConcurrencyInPractice.chapter12;

import com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter12.BoundedBuffer;
import com.mrdios.competencymatrix.test.java.base.BaseTest;
import org.junit.Test;

/**
 * 基于信号量的有界缓存测试
 *
 * @author huxiong
 * @date 2016/06/24 11:31
 */
public class BoundBufferTest extends BaseTest {

    /**
     * 测试缓存初始化时是否为空
     */
    @Test
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isNull());
    }

    /**
     * 测试缓存填满
     * @throws InterruptedException
     */
    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            bb.put(i);
        }
        assertTrue(bb.isNull());
        assertFalse(bb.isEmpty());
    }

    /**
     * 测试从空缓存中take，请求将一直阻塞
     * @throws InterruptedException
     */
    @Test
    public void testTake() throws InterruptedException{
        final BoundedBuffer<Integer> bb = new BoundedBuffer<>(10);
        // 放入缓存数据的线程,先等待5秒
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    bb.put(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        putThread.start();
        Integer n = bb.take();
        System.out.println(n);
    }

}
