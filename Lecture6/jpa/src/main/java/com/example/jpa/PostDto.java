package com.example.jpa;

import com.example.jpa.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-03-01 [2022.3월.01]
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private int id;
    private String title;
    private String content;
    private String writer;
    private int boardId;

}
