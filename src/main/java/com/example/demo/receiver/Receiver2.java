package com.example.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {
    @RabbitListener(queues = "rabbit_queue")
    public void receive(String message) {
        System.out.println("Receiver2收到的 message 是：" + message);
    }
}
