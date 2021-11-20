package br.com.meetingVote.service.impl;

import br.com.meetingVote.service.RabbitMQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Void sendMessage(String queue, Object message) {
        this.rabbitTemplate.convertAndSend(queue, message);
        return null;
    }
}
