package com.example.rabbitproducer.controller;

import com.example.rabbitproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;

    @GetMapping("/")
    public void sendMessage() {
        producerService.send();
    }
}
