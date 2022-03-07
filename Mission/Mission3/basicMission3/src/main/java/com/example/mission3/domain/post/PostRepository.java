package com.example.mission3.domain.post;

import com.example.mission3.domain.PostEntity;
import com.example.mission3.domain.board.BoardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByBoardEntity(BoardEntity boardEntity);
}
