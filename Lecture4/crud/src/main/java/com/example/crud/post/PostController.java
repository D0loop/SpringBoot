package com.example.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Controller
@ResponseBody // PostController 안에 있는 모든 함수에 ResponseBody를 붙여 놓은 효과
@RequestMapping("post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postList;

    public PostController() {
        postList = new ArrayList<>();
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    @GetMapping("read-all")
    public List<PostDto> readPostAll() {
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postList.get(id);
    }

    @PostMapping("update")
    public void updatePost(@RequestParam("id") int id,
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

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postList.remove(id);
    }

}
