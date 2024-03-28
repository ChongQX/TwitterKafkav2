package com.example.demo;

import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;
import org.springframework.kafka.core.KafkaTemplate;

// TwitterStreamListener.java
public class TwitterStreamListener {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TwitterStreamListener(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void startTwitterStream(String keyword) {
        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(new StatusListener() {
            @Override
            public void onStatus(Status status) {
                kafkaTemplate.send("tweets-topic", status.getText());
            }
        });
        FilterQuery query = new FilterQuery().track(keyword);
        twitterStream.filter(query);
    }
}
