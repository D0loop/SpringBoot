package com.example.redisproducer.controller;

import com.example.redisproducer.model.JobProcess;
import com.example.redisproducer.service.ProducerService;
import com.example.redisproducer.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    private final RedisService redisService;

    @GetMapping("/")
    public String sendMessage() {
        return producerService.send();
    }


    @GetMapping("/{jobId}")
    public JobProcess getResult(@PathVariable("jobId") String jobId) {
        return redisService.retrieveJob(jobId);
    }
}
