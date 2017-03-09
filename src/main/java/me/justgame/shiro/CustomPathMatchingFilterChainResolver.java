package me.justgame.shiro;

import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by xcl on 2017-03-08.
 */
public class CustomPathMatchingFilterChainResolver extends PathMatchingFilterChainResolver {
    public CustomPathMatchingFilterChainResolver() {
        super();
    }

    public CustomPathMatchingFilterChainResolver(FilterConfig filterConfig) {
        super(filterConfig);
    }

    @Override
    public FilterChain getChain(ServletRequest request, ServletResponse response, FilterChain originalChain) {
        return super.getChain(request, response, originalChain);
    }
}
