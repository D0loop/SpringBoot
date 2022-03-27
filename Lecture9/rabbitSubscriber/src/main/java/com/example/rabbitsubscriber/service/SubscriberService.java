package com.example.rabbitsubscriber.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Service
@RabbitListener(queues = "#{autoGenQueue.name}")
public class SubscriberService {

    private static final Logger logger = LoggerFactory.getLogger(SubscriberService.class);

    @RabbitHandler
    public void receiveMessage(String messageRaw) {
        logger.info("Received: {}", messageRaw);
    }

}
