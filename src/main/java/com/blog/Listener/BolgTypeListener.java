package com.blog.Listener;

import com.blog.Event.RefreshBlogType;
import com.blog.entity.BlogType;
import com.blog.service.BlogTypeService;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author quan
 * @create 2020-05-01 22:26
 */
@Component
public class BolgTypeListener implements ApplicationListener<ApplicationContextEvent> {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private HttpServletResponse servletResponse;

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        if (event instanceof RefreshBlogType) {
            System.out.println("onApplicationEvent = RefreshBlogType = 检测到事件更新");
            ApplicationContext applicationContext = event.getApplicationContext();
                BlogTypeService blogTypeService = (BlogTypeService)applicationContext.getBean("blogTypeService");
                List<BlogType> blogTypeCountList = blogTypeService.countList();

            for (BlogType blogType : blogTypeCountList) {
                System.out.println(blogType.getTypeName());
            }

            servletContext.setAttribute("blogTypeCountList", blogTypeCountList);
            JSONObject result = new JSONObject();
            result.put("success", Boolean.valueOf(true));
            try {
                ResponseUtil.write(servletResponse, result);
            } catch (Exception e) {
                System.out.println("失败！！！！");
            }
            System.out.println("执行更新");
        }


    }

}
