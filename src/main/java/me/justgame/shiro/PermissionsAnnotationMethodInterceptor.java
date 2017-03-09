package me.justgame.shiro;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;

/**
 * Created by xcl on 2017-03-08.
 */
public class PermissionsAnnotationMethodInterceptor extends AuthorizingAnnotationMethodInterceptor {
    public PermissionsAnnotationMethodInterceptor() {
        super(new PermissionsAnnotationHandler());
    }

    public PermissionsAnnotationMethodInterceptor(AnnotationResolver resolver) {
        super(new PermissionsAnnotationHandler(), resolver);
    }

}
