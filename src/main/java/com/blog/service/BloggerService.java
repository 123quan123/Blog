package com.blog.service;

import com.blog.entity.Blogger;

public abstract interface BloggerService
{
  public abstract Blogger find(Integer id);
  
  public abstract Blogger getByUserName(String paramString);

  public abstract Integer update(Blogger paramBlogger);

  public abstract Integer save(Blogger paramBlogger);
}



/* Location:           D:\classes\

 * Qualified Name:     com.blog.service.BloggerService

 * JD-Core Version:    0.7.0.1

 */