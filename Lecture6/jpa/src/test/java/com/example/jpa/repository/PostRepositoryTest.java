package com.example.jpa.repository;

import com.example.jpa.entity.BoardEntity;
import com.example.jpa.entity.PostEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author D0Loop
 * @since 2022-02-27 [2022.2월.27]
 */

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    public void saveBoard() {
        BoardEntity boardEntity = BoardEntity.builder()
                .name("general board").build();
        boardRepository.save(boardEntity);
    }

    @Test
    public void save_test() {

        BoardEntity boardEntity = boardRepository.findById(1L).orElseThrow(() -> new RuntimeException("data not found"));
        PostEntity postEntity = PostEntity.builder()
                .title("save by spring boot jpa")
                .content("saved by spring boot jpa content")
                .writer("by jpa")
                .boardEntity(boardEntity)
                .build();

        PostEntity savedPostEntity = postRepository.save(postEntity);

        assertThat(savedPostEntity).isEqualTo(postEntity);
    }

    @Test
    public void findAllByWriter_test() {

        BoardEntity boardEntity = boardRepository.findById(1L).orElseThrow(() -> new RuntimeException("data not found"));
        PostEntity postEntity = PostEntity.builder()
                .title("save by spring boot jpa")
                .content("saved by spring boot jpa content")
                .writer("by jpa")
                .boardEntity(boardEntity)
                .build();
        postRepository.save(postEntity);

        List<PostEntity> savedPostEntity = postRepository.findAllByWriter("by jpa");

        assertThat(savedPostEntity.size()).isEqualTo(1);
    }
}