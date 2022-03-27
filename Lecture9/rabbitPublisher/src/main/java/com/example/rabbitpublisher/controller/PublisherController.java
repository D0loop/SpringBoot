package com.example.rabbitpublisher.controller;

import com.example.rabbitpublisher.service.PublisherService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@RestController
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;


    @GetMapping("/")
    public void sendMessage() {
        publisherService.publishMessage();
    }
}
