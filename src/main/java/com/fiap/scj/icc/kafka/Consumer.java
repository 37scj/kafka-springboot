package com.fiap.scj.icc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

//    @KafkaListener(topics = "users", groupId = "group_id")
//    public void consume(String message) throws IOException {
//        logger.info(String.format("#### -> Consumed message -> %s", message));
//    }

    @ConditionalOnProperty(value="consumer", havingValue = "true")
    @KafkaListener(topics = "users", groupId = "group_id")
    @SendTo("users_response")
    String listenAndReply(String message) {
        logger.info("ListenAndReply [{}]", message);
        return "This is a reply sent after receiving message " + message;
    }

    @ConditionalOnProperty(value="response", havingValue = "true")
    @KafkaListener(topics = "users_response", groupId = "group_id")
    public void consumeResponse(String message) throws IOException {
        logger.info(String.format("#### -> Consumed RESPONSE message -> %s", message));
    }

}
