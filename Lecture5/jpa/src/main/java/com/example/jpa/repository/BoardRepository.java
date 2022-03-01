package com.example.jpa.repository;

import com.example.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author D0Loop
 * @since 2022-02-27 [2022.2월.27]
 */

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
