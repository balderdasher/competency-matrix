package com.mrdios.competencymatrix.java.readingnotes.JavaConcurrencyInPractice.chapter11.model;

/**
 * 厕所蹲位
 *
 * @author huxiong
 * @date 2016/06/22 10:52
 */
public class ShitHole {
    private int holeNo; //编号
    private boolean inUse;//使用中?

    public ShitHole(int holeNo) {
        this.holeNo = holeNo;
    }

    public int getHoleNo() {
        return holeNo;
    }

    public void setHoleNo(int holeNo) {
        this.holeNo = holeNo;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
