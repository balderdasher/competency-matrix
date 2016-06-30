package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10;

/**
 * @author huxiong
 * @date 2016/06/28 12:16
 */
public class Parcel {
    private class PContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination{
        private String label;
        private PDestination(String whereto){
            label = whereto;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Destination destination(String s){
        return new PDestination(s);
    }

    public Contents contents(){
        return new PContents();
    }
}
