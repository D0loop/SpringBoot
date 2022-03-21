package pe.example.auth.entity;

import org.springframework.data.repository.CrudRepository;

/**
 * @author D0Loop
 * @since 2022-03-21 [2022.3월.21]
 */

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
