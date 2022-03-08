package com.example.mission3.web;

import com.example.mission3.web.dto.PostDto;
import com.example.mission3.service.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@RestController
@RequestMapping("board/{boardId}/post")
public class PostRestController {

    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);

    private final PostService postService;

    public PostRestController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@PathVariable("boardId") int boardId,
                           @RequestBody PostDto postDto,
                           HttpServletRequest httpServletRequest) {
        logger.info(postDto.toString());
        logger.info(httpServletRequest.getHeader("content-type"));
        postDto.setBoardId(boardId);
        this.postService.createPost(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll(@PathVariable("boardId") int boardId) {
        logger.info("in read all");
        return this.postService.readPostAll(boardId);
    }

    @GetMapping("{id}")
    public PostDto readPostOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id,
                           @Valid @RequestBody PostDto postDto) {

        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }

}
