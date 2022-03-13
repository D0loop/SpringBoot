package com.example.posting.handler;

import com.example.posting.PostController;
import com.example.posting.exception.BaseException;
import com.example.posting.exception.ErrorResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

@RestControllerAdvice
public class PostControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(PostControllerAdvice.class);

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleException(BaseException baseException) {
        logger.debug(baseException.getMessage());
        return new ErrorResponseDto(baseException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handelValidException(MethodArgumentNotValidException exception) {
        logger.debug(exception.getMessage());
        return new ErrorResponseDto(exception.getMessage());
    }
}
