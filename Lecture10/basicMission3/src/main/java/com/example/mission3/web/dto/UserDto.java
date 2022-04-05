package com.example.mission3.web.dto;

import com.example.mission3.domain.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserDto {
    private int id;
    @NotNull(message = "name not null")
    private String name;
    private int age;

    public UserDto(UserEntity entity) {
        this.id = Math.toIntExact(entity.getId());
        this.name = entity.getName();
        this.age = Math.toIntExact(entity.getAge());
    }

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id((long) id)
                .name(name)
                .age((long) age)
                .build();
    }
}
