package com.example.redisproducer.config;

import com.google.gson.Gson;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Configuration
public class ProducerConfig {

    @Bean
    public Queue queue() {
        return new Queue("boot.amqp.worker-queue", true, false, true);
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }
}
