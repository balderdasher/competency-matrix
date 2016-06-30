package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.applicationframe;

/**
 * 温室控制器客户端
 * @author huxiong
 * @date 2016/06/28 23:34
 */
public class GreenhouseController {
    public static void main(String[] args) {
        args = new String[]{"5000"};
        GreenhouseControls controls = new GreenhouseControls();
        controls.addEvent(controls.new Bell(900));
        Event[] events = {
                controls.new LightOn(200),
                controls.new LightOff(400),
        };
        controls.addEvent(controls.new Restart(200,events));
        if (args.length==1){
            controls.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
        }
        controls.run();
    }
}
