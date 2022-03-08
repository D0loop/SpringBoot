package com.example.mission3.domain.shop;

import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.area.AreaEntity;
import com.example.mission3.domain.post.PostEntity;
import com.example.mission3.domain.post.ShopPostEntity;
import com.example.mission3.domain.user.UserEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop")
public class ShopEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @Column(updatable = false)
    private Instant openAt;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(
            targetEntity = AreaEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    @OneToMany(
            targetEntity = CategoryEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<CategoryEntity> categoryEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = ShopPostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<ShopPostEntity> shopPostEntityList = new ArrayList<>();

}
