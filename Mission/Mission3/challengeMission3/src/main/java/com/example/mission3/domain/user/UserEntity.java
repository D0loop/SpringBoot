package com.example.mission3.domain.user;

import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.area.AreaEntity;
import com.example.mission3.domain.post.PostEntity;
import com.example.mission3.domain.shop.CategoryEntity;
import com.example.mission3.domain.shop.ShopEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-07 [2022.3월.07]
 */

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Long age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne(
            targetEntity = AreaEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private List<PostEntity>  postEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private List<ShopEntity> shopEntityList = new ArrayList<>();

}
