package com.example.posting.exception;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

public class PostNotExistException extends BaseException {
    public PostNotExistException() {
        super("target post does not exist");
    }
}
