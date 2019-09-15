package com.aiuiot.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 自定义过滤器，打印请求相应时间
 * @Author aiuiot
 * @Date 2019-09-08 22:27
 **/
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //请求之后
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        // SEND_RESPONSE_FILTER_ORDER 为1000 在整合请求返回之前 比最后的相应高一些
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Long startTime = (Long)ctx.get("startTime");

        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();

        long duration = System.currentTimeMillis() - startTime;

        log.info("uri:{}, duration:{},", uri, duration/100); //请求延迟打印 ms

        return null;
    }
}
