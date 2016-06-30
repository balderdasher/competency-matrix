package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.applicationframe;

/**
 * 框架特定实现：温室控制
 *
 * @author huxiong
 * @date 2016/06/28 22:56
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;

    /**
     * 事件：开灯
     */
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    /**
     * 事件：关灯
     */
    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    /**
     * 事件：浇水
     */
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water is on";
        }
    }

    /**
     * 事件：关水
     */
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "Water is off";
        }
    }

    /**
     * 事件：响铃
     */
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    /**
     * 事件：重启
     */
    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);// 返回每个事件
            }
            start(); // 返回当前事件
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    /**
     * 事件：暂停
     */
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "System terminating";
        }
    }
}
