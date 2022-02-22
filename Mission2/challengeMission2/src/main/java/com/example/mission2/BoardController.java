package com.example.mission2;

import com.example.mission2.domain.board.BoardDto;
import com.example.mission2.service.board.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

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
                           @RequestBody BoardDto boardDto) {
        BoardDto targetBoard = this.boardService.readBoard(id);
        if(boardDto.getName() != null) {
            targetBoard.setName(boardDto.getName());
        }

        this.boardService.updateBoard(id, boardDto);
    }

    @DeleteMapping("{id}")
    public void deleteBoard(@PathVariable("id") int id) {
        this.boardService.deleteBoard(id);
    }
}
