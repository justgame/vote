package me.justgame.shiro;

import me.justgame.dao.AllDao;
import me.justgame.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * Created by xcl on 2017-03-06.
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private AllDao dao;
    @Resource
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        SimpleAuthenticationInfo info;
        String username = (String) token.getPrincipal();
        User user;
        try {
            user = dao.getUserByNo(username);
            UserContext userContext = new UserContext();
            userContext.setUserNo(user.getUserNo());
            userContext.setName(user.getName());
            userContext.setPermissionService(permissionService);
            info = new SimpleAuthenticationInfo(userContext, userContext.getUserNo(), getName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("登录异常", e);
        }
        return info;
    }
}
