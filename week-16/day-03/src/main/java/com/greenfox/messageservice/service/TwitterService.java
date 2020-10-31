package com.greenfox.messageservice.service;

import org.springframework.stereotype.Service;

@Service
public class TwitterService implements MessageService {
  @Override
  public String sendMessage(String message, String email) {
    System.out.println("Twitter sent to: " + email + "\n With message: " + message);
    return ("Twitter sent to: " + email + "\nWith message: " + message);
  }
}
