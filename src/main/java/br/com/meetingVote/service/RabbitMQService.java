package br.com.meetingVote.service;

public interface RabbitMQService {

    Void sendMessage(String queue, Object message);

}
