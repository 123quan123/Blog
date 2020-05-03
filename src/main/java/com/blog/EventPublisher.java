package com.blog;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author quan
 * @create 2020-05-01 23:23
 */

@Component
public class EventPublisher implements ApplicationContextAware {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    public void doPublisher(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }
}
