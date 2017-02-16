package me.justgame.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by xcl on 2017-02-07.
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "myrealm1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        // 仅支持usernamepasswordtoken类型的token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        if (!"zhang".equals(username))
            throw new UnknownAccountException("没有找到该用户");
        if (!"123".equals(password))
            throw new IncorrectCredentialsException("密码错误");
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
