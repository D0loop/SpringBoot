package com.example.mission3.domain.board;

import com.example.mission3.web.dto.BoardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Repository
public class BoardRepositoryInMemory {


    private static final Logger logger = LoggerFactory.getLogger(BoardRepository.class);
    private final List<BoardDto> boardList;

    public BoardRepositoryInMemory() {
        this.boardList = new ArrayList<>();
    }

    public boolean save(BoardDto dto) {
        return this.boardList.add(dto);
    }

    public List<BoardDto> findAll() {
        return this.boardList;
    }

    public BoardDto findById(int id) {

        return this.boardList.stream()
                .filter(boardDto -> boardDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean update(int id, BoardDto dto) {
        BoardDto targetBoard = this.boardList.stream()
                .filter(boardDto -> boardDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        if(dto.getName() != null) {
            targetBoard.setName(dto.getName());
        }

        this.boardList.set(id, dto);
        return true;
    }

    public boolean delete(int id) {
        BoardDto targetBoard = this.boardList.stream()
                .filter(boardDto -> boardDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        this.boardList.remove(targetBoard);
        return true;
    }
}
