package me.justgame.shiro;

import me.justgame.model.Role;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xcl on 2017-03-08.
 */
public class PermissionsAnnotationHandler extends AuthorizingAnnotationHandler {

    public PermissionsAnnotationHandler() {
        super(Permissions.class);
    }

    @Override
    public void assertAuthorized(Annotation annotation) throws AuthorizationException {
        if (!(annotation instanceof Permissions))
            return;
        Permissions permission = (Permissions) annotation;
        Subject subject = getSubject();
        if (!(subject.isAuthenticated() || subject.isRemembered()))
            throw new UnauthenticatedException();

        UserContext userContext = (UserContext) subject.getPrincipal();
        List<Role> roleList = userContext.getRoleByUserNo(userContext.getUserNo());
        List<String> r = new ArrayList<>(roleList.size());
        for (Role role : roleList) {
            r.add(role.getRoleNo());
        }
        String[] roles = permission.roles();
        String requestUri = permission.resourceUri();
        if (!StringUtils.hasText(requestUri) && subject instanceof WebSubject) {
            WebSubject webSubject = (WebSubject) subject;
            ServletRequest request = webSubject.getServletRequest();
            requestUri = WebUtils.getPathWithinApplication(WebUtils.toHttp(request));
        }
        // 权限判断
        if (!r.containsAll(Arrays.asList(roles)))
            throw new UnauthorizedException();
    }
}
