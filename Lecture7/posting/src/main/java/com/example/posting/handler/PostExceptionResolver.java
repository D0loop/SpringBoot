package com.example.posting.handler;

import com.example.posting.exception.BaseException;
import com.example.posting.exception.ErrorResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

@Component
public class PostExceptionResolver extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

//        logger.debug(ex.getClass());
//        if (ex instanceof BaseException) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            try {
//                response.getOutputStream().print(new ObjectMapper().writeValueAsString(
//                        new ErrorResponseDto("in resolver, message: " + ex.getMessage())
//                ));
//                response.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//                return new ModelAndView();
//            } catch (IOException e) {
//                logger.warn("Handling exception caused exception: {}", e);
//            }
//        }

        return null;
    }
}
