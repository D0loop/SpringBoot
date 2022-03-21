package pe.example.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author D0Loop
 * @since 2022-03-21 [2022.3월.21]
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    private String username;
    private String password;
}
