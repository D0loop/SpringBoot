package com.example.posting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author D0Loop
 * @since 2022-03-01 [2022.3월.01]
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private int id;
    @NotNull(message = "title not null")
    private String title;
    @Size(max = 40, message = "content size under 40")
    private String content;
    @Size(min = 3, max = 10, message = "size between 3 ~ 10")
    private String writer;
    private int boardId;

}
