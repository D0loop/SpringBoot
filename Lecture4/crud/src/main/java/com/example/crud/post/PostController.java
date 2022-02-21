package com.example.crud.post;

import com.example.crud.post.domain.PostDto;
import com.example.crud.post.domain.PostRepository;
import com.example.crud.post.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Deprecated
@Controller
@ResponseBody // PostController 안에 있는 모든 함수에 ResponseBody를 붙여 놓은 효과
//@RequestMapping("post")
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private final PostService postService;

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postService.createPost(postDto);
    }

    @GetMapping("read-all")
    public List<PostDto> readPostAll() {
        logger.info("in read all");
        return this.postService.readPostAll();
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id) {
        logger.info("in read one");
        return this.postService.readPost(id);
    }

    @PostMapping("update")
    public void updatePost(@RequestParam("id") int id,
                           @RequestBody PostDto postDto) {
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id) {
        this.postService.deletePost(id);
    }

}
