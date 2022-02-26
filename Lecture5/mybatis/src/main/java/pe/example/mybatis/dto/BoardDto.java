package pe.example.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-02-26 [2022.2월.26]
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
    private int id;
    private String name;
}
