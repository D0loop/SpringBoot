package com.example.rabbitsubscriber.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author D0Loop
 * @since 2022-03-27 [2022.3월.27]
 */

@Configuration
public class SubscriberConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("boot.fanout.exchange");
    }


    @Bean
    public Queue autoGenQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
