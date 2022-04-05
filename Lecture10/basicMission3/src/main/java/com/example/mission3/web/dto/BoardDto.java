package com.example.mission3.web.dto;

import com.example.mission3.domain.board.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author D0Loop
 * @since 2022-02-22 [2022.2월.22]
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BoardDto {

    private int id;
    @NotNull(message = "name not null")
    private String name;

    public BoardDto(BoardEntity entity) {
        this.id = Math.toIntExact(entity.getId());
        this.name = entity.getName();
    }

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .id(Long.valueOf(id))
                .name(name)
                .build();
    }
}
