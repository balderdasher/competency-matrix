package com.mrdios.competencymatrix.springboot.example.event;
import org.springframework.context.ApplicationEvent;

/**
 * 模拟保存一个实体时触发的spring上下文事件，
 *
 * @author huxiong
 * @date 2018-05-02
 */
public class SaveEvent extends ApplicationEvent {
    public SaveEvent(Object source) {
        super(source);
    }
}
