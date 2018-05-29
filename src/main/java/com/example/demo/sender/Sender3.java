package com.example.demo.sender;

import com.example.demo.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender3 {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend("rabbit_queue", user.toString());
    }

}