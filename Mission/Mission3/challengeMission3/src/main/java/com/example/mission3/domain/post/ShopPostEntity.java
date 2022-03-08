package com.example.mission3.domain.post;


import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.board.BoardEntity;
import com.example.mission3.domain.shop.Category;
import com.example.mission3.domain.shop.ShopEntity;
import com.example.mission3.domain.user.UserEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author D0Loop
 * @since 2022-02-27 [2022.2월.27]
 */

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shop_post")
public class ShopPostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostCategory postCategory;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

}
