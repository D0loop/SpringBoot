package com.example.mission3.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Getter
@RequiredArgsConstructor
public enum Role {
    HOST("HOST", "가게 주인"),
    USER("USER", "일반 사용자");

    private final String key;
    private final String title;
}
