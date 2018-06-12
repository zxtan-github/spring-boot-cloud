package org.tanzongxi.spring.springzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;

@Component
public class MyErrorFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String errorFlag = requestContext.getRequest().getParameter("errorFlag");
        if ("true".equals(errorFlag)) {
            logger.info("Logger ErrorFilter...");
            System.out.println("==========ErrorFilter=========");
            throw new ZuulRuntimeException(new ZuulException(new RuntimeException("Exist Error ..."), "Exist error", 500, ""));
        }
        return null;
    }
}
