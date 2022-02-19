package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-02-13 [2022.2월.13]
 */

@Component
public class TestComponent {
    private TestInterface testInterface;

    public TestComponent(TestInterface testInterface, int gradeBean) {
        this.testInterface = testInterface;
        System.out.println("gradeBean : " + gradeBean);
    }

    public void sayHello() {
        this.testInterface.sayHello();
    }
}
