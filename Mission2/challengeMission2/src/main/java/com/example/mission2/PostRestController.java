package com.example.mission2;

import com.example.mission2.domain.FileUploadUtil;
import com.example.mission2.domain.post.PostDto;
import com.example.mission2.service.post.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
                           @RequestBody PostDto postDto) {
        PostDto targetPost = this.postService.readPost(id);
        if(postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }
        if(postDto.getPassword() != null) {
            targetPost.setPassword(postDto.getPassword());
        }

        this.postService.updatePost(id, targetPost);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id, @RequestBody String password) {
        if(password.isEmpty()) {
            throw new RuntimeException("password not insert");
        }
        this.postService.deletePost(id, password);
    }

}
