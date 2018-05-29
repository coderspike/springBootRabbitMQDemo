package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Rabbitmq配置
 */
@Configuration
public class RabbitConfig {

    /**
     * 定义一个队列，队列的名字叫"rabbit_queue"
     *
     * @return
     */
    @Bean
    public Queue Queue() {
        return new Queue("rabbit_queue");
    }

}
