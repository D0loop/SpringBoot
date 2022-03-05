package com.example.jpa.entity;


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
    private String writer;

    @ManyToOne(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

}
