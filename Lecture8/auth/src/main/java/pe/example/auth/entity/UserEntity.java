package pe.example.auth.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author D0Loop
 * @since 2022-03-21 [2022.3월.21]
 */


@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_ENTITY")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;

    @Column
    private String role;
}
