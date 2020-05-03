package com.blog.Event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author quan
 * @create 2020-05-02 15:12
 */
public class RefreshBlog extends ApplicationContextEvent {
    public RefreshBlog(ApplicationContext source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
