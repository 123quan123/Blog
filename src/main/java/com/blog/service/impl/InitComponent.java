/*  1:   */ package com.blog.service.impl;
/*  2:   */
/*  3:   */ import com.blog.entity.Blog;
/*  4:   */ import com.blog.entity.BlogType;
/*  5:   */ import com.blog.entity.Blogger;
/*  6:   */ import com.blog.entity.Link;
/*  7:   */ import com.blog.service.BlogService;
/*  8:   */ import com.blog.service.BlogTypeService;
/*  9:   */ import com.blog.service.BloggerService;
/* 11:   */ import java.util.List;
/* 12:   */ import javax.servlet.ServletContext;
/* 13:   */ import javax.servlet.ServletContextEvent;
/* 14:   */ import javax.servlet.ServletContextListener;
/* 15:   */ import com.blog.service.LinkService;
import org.springframework.beans.BeansException;
/* 16:   */ import org.springframework.context.ApplicationContext;
/* 17:   */ import org.springframework.context.ApplicationContextAware;
/* 18:   */ import org.springframework.stereotype.Component;
/* 19:   */
/* 20:   */ @Component
/* 21:   */ public class InitComponent
        /* 22:   */   implements ServletContextListener, ApplicationContextAware
        /* 23:   */ {
    /* 24:   */   private static ApplicationContext applicationContext;
    /* 25:   */
    /* 26:   */   public void setApplicationContext(ApplicationContext applicationContext)
    /* 27:   */     throws BeansException
    /* 28:   */   {
        /* 29:35 */     this.applicationContext = applicationContext;
        /* 30:   */   }
    /* 31:   */
    /* 32:   */   public void contextInitialized(ServletContextEvent servletContextEvent)
    /* 33:   */   {
        /* 34:39 */     ServletContext application = servletContextEvent.getServletContext();
        /* 39:   */
        /* 40:45 */     BlogTypeService blogTypeService = (BlogTypeService)applicationContext.getBean("blogTypeService");
        /* 41:46 */     List<BlogType> blogTypeCountList = blogTypeService.countList();
        /* 42:47 */     application.setAttribute("blogTypeCountList", blogTypeCountList);
        /* 43:   */
                        BlogService blogService = (BlogService) applicationContext.getBean("blogService");
                        List<Blog> blogCountList = blogService.countList();
                        application.setAttribute("blogCountList", blogCountList);


                        LinkService linkService = applicationContext.getBean(LinkService.class);
                        List<Link> linkList = linkService.list(null);
                        application.setAttribute("linkList", linkList);
        /* 51:   */   }
    /* 52:   */
    /* 53:   */   public void contextDestroyed(ServletContextEvent sce) {}
    /* 54:   */ }


/* Location:           D:\classes\
 * Qualified Name:     com.blog.service.impl.InitComponent
 * JD-Core Version:    0.7.0.1
 */