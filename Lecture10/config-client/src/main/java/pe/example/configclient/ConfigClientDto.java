package pe.example.configclient;

import lombok.*;

import java.util.List;

/**
 * @author D0Loop
 * @since 2022-04-05 [2022.4월.05]
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConfigClientDto {
    private String allowedUser;
    private List<String> allowedHosts;
}
