package com.mrdios.competencymatrix.springboot.example.event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 自定义事件监听器监听特定的事件
 *
 * @author huxiong
 * @date 2018-05-02
 */
@Service
@Transactional
public class SaveEventListener implements ApplicationListener<SaveEvent> {
    private static final Logger logger = LoggerFactory.getLogger(SaveEventListener.class);

    public void onApplicationEvent(SaveEvent saveEvent) {
        logger.error("save event is been fire...");
    }
}
