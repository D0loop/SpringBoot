package com.example.mission3.domain.shop;

import com.example.mission3.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

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
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;
}
