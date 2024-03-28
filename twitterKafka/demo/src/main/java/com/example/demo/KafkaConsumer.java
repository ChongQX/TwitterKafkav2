package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// KafkaConsumer.java
@Component
public class KafkaConsumer {
    @KafkaListener(topics = "tweets-topic")
    public void consume(String tweet) {
        System.out.println("Received tweet: " + tweet);
        // You can save the tweet to a database or process it further
    }
}
