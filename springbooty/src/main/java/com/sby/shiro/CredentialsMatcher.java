package com.sby.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @author zhengzy
 * @date 2018/6/20.
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(uToken.getPassword());
        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();
        //进行密码的比对
        return this.equals(inPassword,dbPassword);
    }
}
