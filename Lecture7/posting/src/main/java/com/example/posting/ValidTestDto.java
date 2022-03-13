package com.example.posting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author D0Loop
 * @since 2022-03-06 [2022.3월.06]
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidTestDto {
    @NotNull // 변수가 null이냐 아니냐
    private String notNullString;

    @NotEmpty // null이 아니면서, Object.size() > 0
    private String notEmptyString;

    @NotBlank // 공백이 아닌 문자열
    private String notBlankString;

    @NotEmpty // null이 아니면서, Object.size() > 0
    private List<String> notEmptyStringList;
}
