package com.sby.shiro;

import com.sby.po.Menu;
import com.sby.po.Role;
import com.sby.po.User;
import com.sby.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by zheng on 2018/6/20.
 */
public class AuthRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = SessionUtils.getSessionUser();
        if (null == user){
            return info;
        }

        String userName = user.getAccount();
        if ("jumore".equals(userName)){
            info.addRole("default");
            info.addStringPermission("*");
            return info;
        }

        Long userId = SessionUtils.getSessionUserId();
        List<Role> roleList  = null;
        if (CollectionUtils.isEmpty(roleList)){
            info.addRole("default");
            info.addStringPermission("");
            return info;
        }

        for (Role role : roleList){
            if (!StringUtils.isEmpty(role.getCode())){
                info.addRole(role.getCode());
            }else {
                info.addRole("default");
            }

            List<Menu> menuList = null;
            for (Menu menu : menuList){
                if (!StringUtils.isEmpty(menu.getCode())){
                    info.addStringPermission(menu.getCode());
                }
            }
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String)token.getPrincipal();
        String password =new String((char[])token.getCredentials());
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            throw new RuntimeException("用户名或密码不能为空");
        }
        User user = userService.getUserInfo(userName,password);
        if (null == user){
            throw new RuntimeException("用户名或密码不正确");
        }
        SessionUtils.setSessionUser(user);
        return new SimpleAuthenticationInfo(userName,password,getName());
    }
}
