package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author D0Loop
 * @since 2022-02-13 [2022.2월.13]
 */

@Configuration
public class TestConfig {

    @Bean
    public int gradeBean() {
        return 10;
    }
}
