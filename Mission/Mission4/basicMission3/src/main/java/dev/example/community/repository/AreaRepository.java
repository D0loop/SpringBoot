package dev.example.community.repository;

import dev.example.community.entity.AreaEntity;
import org.springframework.data.repository.CrudRepository;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
