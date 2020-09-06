//package com.fiap.scj.icc.configs;
//
//import lombok.extern.java.Log;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.SendTo;
//
//import java.util.Properties;
//
//import static java.util.Collections.singleton;
//import static org.apache.kafka.clients.consumer.ConsumerConfig.*;
//import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
//import static org.apache.kafka.clients.producer.ProducerConfig.*;
//
//@Log
//@Configuration
//public class KafkaConfiguration {
//
//    private static final String CONSUMER_GROUP_ID = "my-group-id";
//    private static final String OUTPUT_TOPIC = "output";
//    private static final String INPUT_TOPIC = "input";
//
//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    private KafkaConsumer<String, String> createKafkaConsumer() {
//        Properties props = new Properties();
//        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(GROUP_ID_CONFIG, CONSUMER_GROUP_ID);
////        props.put(ENABLE_AUTO_COMMIT_CONFIG, "false");
//        props.put(ISOLATION_LEVEL_CONFIG, "read_committed");
//        props.put(KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put(VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(singleton(INPUT_TOPIC));
//        return consumer;
//    }
//
//    @Bean
//    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
//    private KafkaProducer<String, String> createKafkaProducer() {
//
//        Properties props = new Properties();
//        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ENABLE_IDEMPOTENCE_CONFIG, "true");
//        props.put(TRANSACTIONAL_ID_CONFIG, "prod-1");
//        props.put(KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        props.put(VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//
//        return new KafkaProducer(props);
//
//    }
//
//    @KafkaListener(topics = "reflectoring-others")
//    @SendTo("reflectoring-1")
//    String listenAndReply(String message) {
//        LOG.info("ListenAndReply [{}]", message);
//        return "This is a reply sent after receiving message";
//    }
//}
