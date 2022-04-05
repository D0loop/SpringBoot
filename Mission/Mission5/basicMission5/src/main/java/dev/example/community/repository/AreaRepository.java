package dev.example.community.repository;

import dev.example.community.controller.dto.AreaWithDistanceDto;
import dev.example.community.entity.AreaEntity;
import dev.example.community.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {

    @Query(value = "SELECT b.* FROM " +
            "(SELECT st_distance(POINT(a.latitude, a.longitude), POINT(:latitude, :longitude)) distance, a.* FROM area a) b" +
            "ORDER BY b.distance ASC limit 1", nativeQuery = true)
    Optional<AreaEntity> findByClosePlace(@Param("latitude") String latitude, @Param("longitude") String longitude);

}
