/*  1:   */ package com.blog.controller.tourists;
/*  2:   */ 
/*  3:   */

import com.blog.Event.RefreshBlogType;
import com.blog.EventPublisher;
import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import com.blog.util.CryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*  4:   */
/*  5:   */
/*  6:   */
/*  7:   */
/*  8:   */
/*  9:   */
/* 10:   */
/* 11:   */
/* 12:   */
/* 13:   */

/* 14:   */
/* 15:   */ @Controller
/* 16:   */ @RequestMapping({"/blogger"})
/* 17:   */ public class BloggerController
/* 18:   */ {
/* 19:   */   @Resource
/* 20:   */   private BloggerService bloggerService;
              @Resource
              private EventPublisher publisher;
              @Resource
              private ApplicationContext applicationContext;
/* 21:   */   
/* 22:   */   @RequestMapping({"/login"})
/* 23:   */   public String login(Blogger blogger, HttpServletRequest request)
/* 24:   */   {
                //shiro鉴别
/* 25:37 */     Subject subject = SecurityUtils.getSubject();
/* 26:38 */     UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), CryptographyUtil.md5(blogger.getPassword(), "java1234"));
/* 27:   */     try
/* 28:   */     {
                  //传递token给shiro的realm
/* 29:40 */       subject.login(token);
/* 30:41 */       return "redirect:/admin/main.jsp";
/* 31:   */     }
/* 32:   */     catch (Exception e)
/* 33:   */     {
///* 34:43 */       e.printStackTrace();
/* 35:44 */       request.setAttribute("blogger", blogger);
                  publisher.doPublisher(new RefreshBlogType(applicationContext));
/* 36:45 */       request.setAttribute("errorInfo", "用户名或密码错误！");
/* 37:   */     }
/* 38:46 */     return "login";
/* 39:   */   }
///* 40:   */
///* 41:   */   @RequestMapping({"/aboutMe"})
///* 42:   */   public ModelAndView aboutMe(Integer id)
///* 43:   */     throws Exception
///* 44:   */   {
///* 45:57 */     ModelAndView mav = new ModelAndView();
///* 46:58 */     mav.addObject("blogger", this.bloggerService.find(id));
//    //TODO
///* 47:59 */     mav.addObject("mainPage", "foreground/blogger/info.jsp");
///* 48:60 */     mav.addObject("pageTitle", "关于博主_Java开源博客系统");
///* 49:61 */     mav.setViewName("mainTemp");
///* 50:62 */     return mav;
///* 51:   */   }
/* 52:   */ }



/* Location:           D:\classes\

 * Qualified Name:     com.blog.controller.BloggerController

 * JD-Core Version:    0.7.0.1

 */