package com.example.mission3.domain.shop;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author D0Loop
 * @since 2022-03-08 [2022.3월.08]
 */

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("FOOD", "식품"),
    DRINK("DRINK", "음료"),
    SNACK("SNACK", "간식");

    private final String key;
    private final String title;
}
