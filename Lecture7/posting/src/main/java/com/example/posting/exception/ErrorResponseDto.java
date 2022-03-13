package com.example.posting.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-03-13 [2022.3월.13]
 */

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
}
