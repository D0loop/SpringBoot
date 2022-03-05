package com.example.jpa.repository;

import com.example.jpa.entity.BoardEntity;
import com.example.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-02-27 [2022.2월.27]
 */

public interface PostRepository extends CrudRepository<PostEntity, Long> {

    List<PostEntity> findAllByWriter(String writer);
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity);
    List<PostEntity> findAllByWriterContaining(String writer);
}
