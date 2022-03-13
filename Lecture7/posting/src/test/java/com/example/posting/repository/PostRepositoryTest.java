package com.example.posting.repository;

import com.example.posting.entity.BoardEntity;
import com.example.posting.entity.PostEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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