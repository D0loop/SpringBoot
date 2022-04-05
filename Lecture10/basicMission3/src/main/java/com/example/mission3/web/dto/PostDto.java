package com.example.mission3.web.dto;

import com.example.mission3.domain.board.BoardEntity;
import com.example.mission3.domain.PostEntity;
import com.example.mission3.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author D0Loop
 * @since 2022-02-20 [2022.2월.20]
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PostDto {

    private int id;
    private int boardId;
    @NotNull(message = "title not null")
    private String title;
    @NotNull(message = "content not null")
    private String content;
    private int userId;


    public PostDto(PostEntity entity) {
        this.id = Math.toIntExact(entity.getId());
        this.boardId = Math.toIntExact(entity.getBoardEntity().getId());
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.userId = Math.toIntExact(entity.getUserEntity().getId());
    }

    public PostEntity toEntity() {
        return PostEntity.builder()
                .id((long) id)
                .title(title)
                .content(content)
                .userEntity(UserEntity.builder().id((long) userId).build())
                .boardEntity(BoardEntity.builder().id((long) boardId).build())
                .build();
    }
}
