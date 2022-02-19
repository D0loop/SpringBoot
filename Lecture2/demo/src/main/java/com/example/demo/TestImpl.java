package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-02-13 [2022.2월.13]
 */

@Component
public class TestImpl implements TestInterface{
    @Override
    public void sayHello() {
        System.out.printf("HELLO");
    }
}
