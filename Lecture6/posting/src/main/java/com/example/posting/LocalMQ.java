package com.example.posting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author D0Loop
 * @since 2022-03-05 [2022.3월.05]
 */

@Component
@Profile("!test")
public class LocalMQ implements MessageQueueInterface {

    public static final Logger logger = LoggerFactory.getLogger(MessageQueueInterface.class);

    public LocalMQ() {
        logger.info("bean local");
    }
    
    @Override
    public String readMessage() {
        return "Local MQ";
    }
}
