package com.example.redisproducer.service;

import com.example.redisproducer.model.JobRequest;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    private final RabbitTemplate rabbitTemplate;
    private final Queue rabbitQueue;
    private final Gson gson;


    public String send() {
        JobRequest jobRequest = new JobRequest(UUID.randomUUID().toString());



        rabbitTemplate.convertAndSend(rabbitQueue.getName(), gson.toJson(jobRequest));
        logger.info("Send message: {}", gson.toJson(jobRequest));

        return jobRequest.getJobId();
    }

}
