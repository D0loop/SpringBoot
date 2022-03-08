package com.example.mission3.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Getter
@RequiredArgsConstructor
public enum PostCategory {
    NOTICE("NOTICE", "공지"),
    REVIEW("REVIEW", "리뷰");

    private final String key;
    private final String title;
}
