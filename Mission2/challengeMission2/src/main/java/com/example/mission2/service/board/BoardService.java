package com.example.mission2.service.board;


import com.example.mission2.domain.board.BoardDto;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public interface BoardService {

    void createBoard(BoardDto dto);
    List<BoardDto> readBoardAll();
    BoardDto readBoard(int id);
    boolean updateBoard(int id, BoardDto dto);
    boolean deleteBoard(int id);
}
