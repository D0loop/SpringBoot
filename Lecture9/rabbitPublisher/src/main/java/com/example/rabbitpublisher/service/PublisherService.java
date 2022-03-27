package com.example.rabbitpublisher.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Service
@RequiredArgsConstructor
@RabbitListener(queues = "boot.amqp.worker-queue")
public class PublisherService {

    private static final Logger logger = LoggerFactory.getLogger(PublisherService.class);

    private final RabbitTemplate rabbitTemplate;
    private final FanoutExchange fanoutExchange;

    AtomicInteger dots = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    public void publishMessage() {
        String message = "Message Count : " + count.incrementAndGet();

        rabbitTemplate.convertAndSend(
                fanoutExchange.getName(),
                "",
                message
        );
    }

}
