package com.mrdios.competencymatrix.java.readingnotes.ThinkingInJava.chapter10.applicationframe;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来管理并触发时间的实际控制框架
 * @author huxiong
 * @date 2016/06/28 22:36
 */
public class Controller {
    /** 事件列表 */
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event e){
        eventList.add(e);
    }

    public void run(){
        while(eventList.size() > 0){
            // 拷贝事件列表以便读取的元素的时候去不更新事件列表
            for (Event e:new ArrayList<>(eventList)) {
                if (e.ready()){
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
