package com.blog.Listener;

import com.blog.Event.RefreshBlog;
import com.blog.Event.RefreshBlogType;
import com.blog.entity.Blog;
import com.blog.entity.BlogType;
import com.blog.service.BlogService;
import com.blog.service.BlogTypeService;
import com.blog.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author quan
 * @create 2020-05-02 15:13
 */
public class BlogListener implements ApplicationListener<ApplicationContextEvent> {

    @Autowired
    private ServletContext servletContext;
    @Autowired
    private HttpServletResponse servletResponse;


    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        if (event instanceof RefreshBlog) {
            System.out.println("onApplicationEvent = RefreshBlogType = 检测到事件更新");
            ApplicationContext applicationContext = event.getApplicationContext();
            BlogService blogService = (BlogService) applicationContext.getBean("blogService");
            List<Blog> blogCountList = blogService.countList();

            for (Blog blog : blogCountList) {
                System.out.println(blog.getTitle());
            }

            servletContext.setAttribute("blogCountList", blogCountList);
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
