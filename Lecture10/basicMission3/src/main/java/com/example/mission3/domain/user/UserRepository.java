package com.example.mission3.domain.user;

import org.springframework.data.repository.CrudRepository;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
