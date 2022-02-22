package com.example.mission2.domain.post;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

public interface PostRepository {

    boolean save(PostDto dto);
    List<PostDto> findAll(int boardId);
    PostDto findById(int id);
    boolean update(int id, PostDto dto);
    boolean delete(int id, String password);
}
