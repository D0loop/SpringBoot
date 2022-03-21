package dev.example.community.repository;

import dev.example.community.entity.ShopPostEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopPostRepository extends CrudRepository<ShopPostEntity, Long> {
}
