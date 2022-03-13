package com.example.posting.exception;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
