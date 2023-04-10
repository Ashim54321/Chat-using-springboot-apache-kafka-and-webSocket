package com.example.kafka.repository;

import com.example.kafka.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MessageRepository extends MongoRepository<Message, String> {
}
