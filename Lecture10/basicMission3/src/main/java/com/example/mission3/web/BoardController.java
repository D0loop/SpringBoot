package com.example.mission3.web;

import com.example.mission3.web.dto.BoardDto;
import com.example.mission3.service.board.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Profile("board")
@RestController
@RequestMapping("board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;

    public BoardController(@Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody BoardDto boardDto, HttpServletRequest httpServletRequest) {
        logger.info(boardDto.toString());
        logger.info(httpServletRequest.getHeader("content-type"));
        this.boardService.createBoard(boardDto);
    }

    @GetMapping()
    public List<BoardDto> readBoardAll() {
        logger.info("in read all");
        return this.boardService.readBoardAll();
    }

    @GetMapping("{id}")
    public BoardDto readBoardOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.boardService.readBoard(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoard(@PathVariable("id") int id,
                           @Valid @RequestBody BoardDto boardDto) {

        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable("id") int id) {
        this.boardService.deleteBoard(id);
    }
}
