package com.example.mission3.domain.user;

import com.example.mission3.domain.BaseEntity;
import com.example.mission3.domain.PostEntity;
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

    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private List<PostEntity>  postEntityList = new ArrayList<>();
}
