package pe.example.mybatis.dto;

import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.io.IOException;

/**
 * @author D0Loop
 * @since 2022-02-24 [2022.2월.24]
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ConstructorBinding
@Builder
@ToString
@EqualsAndHashCode
public class PostDto {

    private int id;
    private int boardId;
    private String title;
    private String content;
    private String writer;

}
