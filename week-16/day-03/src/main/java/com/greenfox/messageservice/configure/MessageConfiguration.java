package com.greenfox.messageservice.configure;

import com.greenfox.messageservice.service.EmailService;
import com.greenfox.messageservice.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {

  @Bean
  EmailService emailService(){
    return new EmailService();
  }

  TwitterService twitterService(){
    return new TwitterService();
  }
}
