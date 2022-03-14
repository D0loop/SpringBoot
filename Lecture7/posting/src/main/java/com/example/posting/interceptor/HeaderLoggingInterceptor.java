package com.example.posting.interceptor;

import com.example.posting.filter.TransactionLogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

/**
 * @author D0Loop
 * @since 2022-03-14 [2022.3월.14]
 */

@Component
public class HeaderLoggingInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(HeaderLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("preHandle processing of {}", handlerMethod.getMethod().getName());

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.trace("{} : {}", headerName, request.getHeader(headerName));
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("postHandle processing of {}", handlerMethod.getMethod().getName());

        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            logger.trace("{} : {}", headerName, request.getHeader(headerName));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("afterCompletion processing of {}", handlerMethod.getMethod().getName());

        if(ex != null) logger.error("Exception occurred while processing", ex);
    }
}
