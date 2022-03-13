package com.example.posting.exception;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

public class PostNotInBoardException extends BaseException {
    // board랑 post를 입력으로 받고자하는데 요청한 post가 요청한 board에 없을때 발생하는 오류

    public PostNotInBoardException() {
        super("Post not in board");
    }
}
