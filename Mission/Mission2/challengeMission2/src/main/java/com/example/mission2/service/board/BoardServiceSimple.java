package com.example.mission2.service.board;

import com.example.mission2.domain.board.BoardDto;

import com.example.mission2.domain.board.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Service
public class BoardServiceSimple implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);

    private final BoardRepository boardRepository;

    public BoardServiceSimple(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void createBoard(BoardDto dto) {

        if(!this.boardRepository.save(dto)) {
            throw new RuntimeException("save failed");
        };
    }

    @Override
    public List<BoardDto> readBoardAll() {
        return this.boardRepository.findAll();
    }

    @Override
    public BoardDto readBoard(int id) {
        return this.boardRepository.findById(id);
    }

    @Override
    public boolean updateBoard(int id, BoardDto dto) {
        return this.boardRepository.update(id, dto);
    }

    @Override
    public boolean deleteBoard(int id) {
        return this.boardRepository.delete(id);
    }
}
