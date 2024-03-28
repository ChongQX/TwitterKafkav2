package com.example.demo;

// TwitterConfig.java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {

    @Bean
    public TwitterStream twitterStream() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("YOUR_CONSUMER_KEY")
                .setOAuthConsumerSecret("YOUR_CONSUMER_SECRET")
                .setOAuthAccessToken("YOUR_ACCESS_TOKEN")
                .setOAuthAccessTokenSecret("YOUR_ACCESS_TOKEN_SECRET");

        return new TwitterStreamFactory(cb.build()).getInstance();
    }
}
