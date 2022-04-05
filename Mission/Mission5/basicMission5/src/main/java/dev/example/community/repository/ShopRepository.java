package dev.example.community.repository;

import dev.example.community.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
