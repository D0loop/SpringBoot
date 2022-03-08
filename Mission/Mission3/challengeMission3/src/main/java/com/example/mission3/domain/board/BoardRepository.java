package com.example.mission3.domain.board;


import org.springframework.data.repository.CrudRepository;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
