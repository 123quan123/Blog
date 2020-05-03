package com.blog.dao;

import com.blog.entity.Blogger;
import org.apache.ibatis.annotations.Param;

public abstract interface BloggerDao
{
  public abstract Blogger find(Integer id);
  
  public abstract Blogger getByUserName(@Param("userName") String paramString);
  
  public abstract Integer update(Blogger paramBlogger);

  public abstract Integer save(Blogger paramBlogger);
}



/* Location:           D:\classes\

 * Qualified Name:     com.blog.dao.BloggerDao

 * JD-Core Version:    0.7.0.1

 */