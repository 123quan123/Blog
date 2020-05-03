package com.blog.realm;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.Authenticator;
import java.util.Collection;

/**
 * @author quan
 * @create 2020-05-01 11:46
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private BloggerService bloggerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录验证
     * token：基于用户名和密码的令牌
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();

        //让shrio去判断
        Blogger blogger = bloggerService.getByUserName(username);
        if (blogger != null) {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
    }
}
