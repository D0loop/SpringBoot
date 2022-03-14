package com.example.posting.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

@Component
public class TransactionLogFilter implements Filter {

    public static final Logger logger = LoggerFactory.getLogger(TransactionLogFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestUUID = UUID.randomUUID().toString().split("-")[0];
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        logger.debug("[{}] start request: {} {}", requestUUID, httpServletRequest.getMethod(), httpServletRequest.getRequestURI());

        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());


        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        chain.doFilter(request, response);
        requestWrapper.getContentAsByteArray(); // 읽혀진 httpServletRequest의 인풋 스트림의 결과 내용을 다시 한번 불러올 수 있다.

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        logger.info(" * response status code: {}", ((HttpServletResponse) response).getStatus());
        logger.debug("[{}] send response: {}", requestUUID, httpServletResponse.getStatus());
    }
}
