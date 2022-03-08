package com.example.mission3.domain.post;


import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.board.BoardEntity;
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
@Table(name = "post")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

}
