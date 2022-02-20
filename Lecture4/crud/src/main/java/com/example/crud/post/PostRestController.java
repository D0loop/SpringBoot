package com.example.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@RestController
@RequestMapping("post")
public class PostRestController {

    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final List<PostDto> postList;

    public PostRestController() {
        postList = new ArrayList<>();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("{id}")
    public PostDto readPostOne(@PathVariable("id") int id) {
        logger.info("in read one");
        return this.postList.get(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id,
                           @RequestBody PostDto postDto) {
        PostDto targetPost = this.postList.get(id);
        if(postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }

        this.postList.set(id, postDto);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postList.remove(id);
    }

}
