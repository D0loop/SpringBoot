package com.example.aspect;

import com.example.aspect.aspect.LogExecutionTime;
import com.example.aspect.aspect.LogArguments;
import com.example.aspect.aspect.LogResult;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-01 [2022.3월.01]
 */

@RestController
@RequestMapping("post")
@RequiredArgsConstructor
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
    private final Gson gson;

//    public PostController(PostService postService, GsonComponent gson) {
//        this.postService = postService;
//        this.gson = gson.getGson();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto) {
        this.postService.createPost(postDto);
    }

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        return this.postService.readPost(id);
    }

    @LogResult
    @GetMapping("")
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDto postDto) {
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postService.deletePost(id);
    }

    @LogArguments
    @LogExecutionTime
    @GetMapping("test-log")
    public void testLog() {

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

    }
}
