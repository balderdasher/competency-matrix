package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter11;


import com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter11.model.ShitHole;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

/**
 * 缩小锁的范围
 *
 * @author huxiong
 * @date 2016/06/22 10:50
 */
public class ReduceLockRange {
    /**
     * 厕所蹲位信息
     */
    @Generated("this")
    private Map<Integer, ShitHole> shitHoles = new HashMap<>();

    public ReduceLockRange(Map<Integer, ShitHole> shitHoles) {
        this.shitHoles = shitHoles;
    }

    /**
     * 上厕所
     * 更好的做法是只同步hole = shitHoles.get(holeIndex);这一句而不用同步整个方法
     *
     * @param holeIndex 当前排队的蹲位编号
     * @param customer  上厕所的人
     * @return true or false
     */
    public synchronized boolean gotoShit(Integer holeIndex, String customer) throws InterruptedException{
        ShitHole hole;
        String message;
        hole = shitHoles.get(holeIndex);
        if (hole.isInUse()) {
            message = "对不起，" + customer + ",第" + holeIndex + "个蹲位有人了";
            System.out.println(message);
            return false;
        } else {
            hole.setInUse(true);
            message = "第" + holeIndex + "个蹲位被" + customer + "承包了";
            System.out.println(message);
            Thread.sleep(5000);
            return true;
        }
    }


    public static void main(String[] args) {
        Map<Integer, ShitHole> shitHoleMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            ShitHole hole = new ShitHole(i + 1);
            shitHoleMap.put(hole.getHoleNo(), hole);
        }

        final ReduceLockRange reduceLockRange = new ReduceLockRange(shitHoleMap);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reduceLockRange.gotoShit(1, "三胖");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reduceLockRange.gotoShit(1, "奥巴马");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
