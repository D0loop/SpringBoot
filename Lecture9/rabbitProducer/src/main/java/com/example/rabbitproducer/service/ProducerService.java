package com.example.rabbitproducer.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

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

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    public void send() {
        StringBuilder stringBuilder = new StringBuilder("hello");
        if(dots.incrementAndGet() == 4) {
            dots.set(1);
        }

        stringBuilder.append(".".repeat(dots.get()));
        stringBuilder.append(count.incrementAndGet());
        String message = stringBuilder.toString();

        rabbitTemplate.convertAndSend(rabbitQueue.getName(), message);
        logger.info("Send message: {}", message);
    }

}
