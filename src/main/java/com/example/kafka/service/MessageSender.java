package com.example.kafka.service;

import com.example.kafka.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSender {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaListener.class);

    public final KafkaTemplate<String, Message> messageKafkaTemplate;

    public void sendMessage(Message message) {
        LOGGER.info(String.format("Message Send %S", message.toString()));
        messageKafkaTemplate.send("topic", message);
    }
}
