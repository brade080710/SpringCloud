package com.it.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * filterType：返回过滤器的类型。有pre、route、post、error等几种取值，分别对应上文的几种过滤器。详细可以参考com.netflix.zuul.ZuulFilter.filterType() 中的注释。
 * filterOrder：返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
 * shouldFilter：返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行。
 * run：过滤器的具体逻辑。本例中，我们让它打印了请求的HTTP方法以及请求的地址
 *
 */
public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}