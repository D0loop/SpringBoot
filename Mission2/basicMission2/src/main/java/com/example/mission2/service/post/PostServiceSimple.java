package com.example.mission2.service.post;

import com.example.mission2.domain.post.PostDto;
import com.example.mission2.domain.post.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Service
public class PostServiceSimple implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);

    private final PostRepository postRepository;

    public PostServiceSimple(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {

        if(!this.postRepository.save(dto)) {
            throw new RuntimeException("save failed");
        };
    }

    @Override
    public List<PostDto> readPostAll(int boardId) {
        return this.postRepository.findAll(boardId);
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public boolean updatePost(int id, PostDto dto) {
        return this.postRepository.update(id, dto);
    }

    @Override
    public boolean deletePost(int id, String passwoard) {
        return this.postRepository.delete(id, passwoard);
    }
}
