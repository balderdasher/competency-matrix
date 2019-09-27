package com.mrdios.competencymatrix.springboot.example.event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huxiong
 * @date 2018-05-02
 */
@Service
public class SaveService {
    private static final Logger logger = LoggerFactory.getLogger(SaveService.class);

    @Resource
    private ApplicationEventPublisher eventPublisher;

    public void save() {
        logger.error("save something...");
        eventPublisher.publishEvent(new SaveEvent(this));
    }
}
