package com.example.mission3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicMission3Application {

    public static void main(String[] args) {
        SpringApplication.run(BasicMission3Application.class, args);
    }

}
