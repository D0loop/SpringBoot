package com.example.mission2.domain.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Repository
public class PostRepositoryInMemory implements PostRepository {

    private static final Logger logget = LoggerFactory.getLogger(PostRepositoryInMemory.class);
    private final List<PostDto> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);
    }

    @Override
    public List<PostDto> findAll(int boardId) {
        return this.postList.stream()
                .filter(dto -> dto.getBoardId() == boardId)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(int id) {

        return this.postList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public boolean update(int id, PostDto dto) {
        PostDto targetPost = this.postList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        if(dto.getTitle() != null) {
            targetPost.setTitle(dto.getTitle());
        }
        if(dto.getContent() != null) {
            targetPost.setContent(dto.getContent());
        }

        this.postList.set(id, dto);
        return true;
    }

    @Override
    public boolean delete(int id, String password) {
        PostDto targetPost = this.postList.stream()
                .filter(postDto -> postDto.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        if(targetPost.getPassword().equals(password)) {
            this.postList.remove(targetPost);
            return true;
        }
        return false;
    }
}
