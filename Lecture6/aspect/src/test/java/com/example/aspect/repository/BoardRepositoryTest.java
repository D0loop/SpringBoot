package com.example.aspect.repository;

import com.example.aspect.entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author D0Loop
 * @since 2022-02-27 [2022.2월.27]
 */

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void save_test() {
        BoardEntity boardEntity = BoardEntity.builder()
                .name("mobile board").build();

        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);

        assertThat(boardEntity).isEqualTo(savedBoardEntity);
    }
}