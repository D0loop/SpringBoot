package com.example.jpa.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
@Table(name = "board")
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "boardEntity")
    private List<PostEntity> postEntityList = new ArrayList<>();
}
