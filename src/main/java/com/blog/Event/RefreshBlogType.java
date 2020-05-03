package com.blog.Event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import java.util.List;

/**
 * @author quan
 * @create 2020-05-01 22:22
 */
public class RefreshBlogType extends ApplicationContextEvent {
    public RefreshBlogType(ApplicationContext source) {
        super(source);
        System.out.println("检测到更新");
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
