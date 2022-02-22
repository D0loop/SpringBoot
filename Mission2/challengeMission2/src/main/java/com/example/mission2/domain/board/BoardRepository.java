package com.example.mission2.domain.board;


import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public interface BoardRepository {

    boolean save(BoardDto dto);
    List<BoardDto> findAll();
    BoardDto findById(int id);
    boolean update(int id, BoardDto dto);
    boolean delete(int id);
}
