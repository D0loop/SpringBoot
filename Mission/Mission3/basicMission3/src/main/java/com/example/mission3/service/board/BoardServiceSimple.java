package com.example.mission3.service.board;

import com.example.mission3.domain.board.BoardEntity;
import com.example.mission3.domain.PostEntity;
import com.example.mission3.web.dto.BoardDto;

import com.example.mission3.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Service
@RequiredArgsConstructor
public class BoardServiceSimple implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(BoardServiceSimple.class);

    private final BoardRepository boardRepository;

    @Override
    public void createBoard(BoardDto dto) {
        this.boardRepository.save(dto.toEntity());
    }

    @Override
    public List<BoardDto> readBoardAll() {
        Iterator<BoardEntity> iterator = boardRepository.findAll().iterator();
        List<BoardDto> result = new ArrayList<>();

        while (iterator.hasNext()) {
            BoardEntity boardEntity = iterator.next();
            result.add(BoardDto.builder()
                    .id(Math.toIntExact(boardEntity.getId()))
                    .name(boardEntity.getName())
                    .build());

        }
        return result;
    }

    @Override
    public BoardDto readBoard(int id) {
        return this.boardRepository.findById((long) id)
                .map(BoardDto::new)
                .orElseThrow(() -> new IllegalArgumentException("No board has id = " + id));
    }

    @Override
    public List<PostEntity> readPostAtBoard(int id) {
        BoardEntity boardEntity = this.boardRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("No board has id = " + id));
        return boardEntity.getPostEntityList();
    }

    @Override
    public void updateBoard(int id, BoardDto dto) {

        BoardEntity targetEntity = this.boardRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        logger.info(targetEntity.toString());

        targetEntity.setName(dto.getName() == null ? targetEntity.getName() : dto.getName());

        logger.info(targetEntity.toString());

        this.boardRepository.save(targetEntity);
    }

    @Override
    public void deleteBoard(int id) {

        BoardEntity targetEntity = this.boardRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("No board has id = " + id));

        this.boardRepository.delete(targetEntity);
    }
}
