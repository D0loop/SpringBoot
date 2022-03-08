package com.example.mission3.service.board;


import com.example.mission3.domain.post.PostEntity;
import com.example.mission3.web.dto.BoardDto;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public interface BoardService {

    void createBoard(BoardDto dto);
    List<BoardDto> readBoardAll();
    BoardDto readBoard(int id);
    List<PostEntity> readPostAtBoard(int id);
    void updateBoard(int id, BoardDto dto);
    void deleteBoard(int id);
}
