package com.greenfox.messageservice.configure;

import com.greenfox.messageservice.service.EmailService;
import com.greenfox.messageservice.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MessageConfiguration {

  @Bean
  @Primary
  EmailService sendEmail123(){
    return new EmailService();
  }

  TwitterService twitter(){
    return new TwitterService();
  }
}
