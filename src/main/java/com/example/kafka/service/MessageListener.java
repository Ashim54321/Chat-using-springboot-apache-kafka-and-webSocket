package com.example.kafka.service;

import com.example.kafka.domain.Message;
import com.example.kafka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    SimpMessagingTemplate template;


    @KafkaListener(topics = "topic",groupId = "${spring.kafka.consumer.group-id}")
    public void messageListener(Message message){
        template.convertAndSend("/topic/group", message);
    }
}
