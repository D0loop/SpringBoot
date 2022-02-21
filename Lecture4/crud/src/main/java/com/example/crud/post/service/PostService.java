package com.example.crud.post.service;

import com.example.crud.post.domain.PostDto;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    boolean updatePost(int id, PostDto dto);
    boolean deletePost(int id);

}
