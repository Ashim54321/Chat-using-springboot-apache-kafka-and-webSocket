package com.example.kafka.resource;

import com.example.kafka.domain.Message;
import com.example.kafka.service.MessageListener;
import com.example.kafka.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageController {

    private final MessageSender messageSender;
    private final MessageListener messageListener;

    @PostMapping(value = "/message", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody Message message) {
        messageSender.sendMessage(message);
    }
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        //Sending this message to all the subscribers
        return message;
    }
    @MessageMapping("/newUser")
    @SendTo("/topic/group")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        // Add user in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getUsername());
        return message;
    }
}
