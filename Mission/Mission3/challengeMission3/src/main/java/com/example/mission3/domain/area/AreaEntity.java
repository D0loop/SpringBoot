package com.example.mission3.domain.area;

import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.shop.CategoryEntity;
import com.example.mission3.domain.shop.ShopEntity;
import com.example.mission3.domain.user.UserEntity;
import lombok.*;

import javax.persistence.*;
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
@Table(name = "area")
public class AreaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nation;
    private String city;
    private String state;
    private String zipCode;
    private String streetAddress1;
    private String streetAddress2;
    private Double latitude;
    private Double longitude;

    @OneToMany(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity")
    private List<UserEntity> userEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity")
    private List<ShopEntity> shopEntityList = new ArrayList<>();

}
