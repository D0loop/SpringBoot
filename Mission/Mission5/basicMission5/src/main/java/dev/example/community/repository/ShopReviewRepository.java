package dev.example.community.repository;

import dev.example.community.entity.ShopReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
