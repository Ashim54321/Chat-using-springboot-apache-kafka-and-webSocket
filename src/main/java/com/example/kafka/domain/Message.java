package com.example.kafka.domain;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
@ToString
@Builder
public class Message {
    private String username;
    private String Message;
}
