package com.greenfox.messageservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService implements MessageService {

  @Override
  public String sendMessage(String message, String email) {
    System.out.println("Email sent to: " + email + "\n With message: " + message);
    return ("Email sent to: " + email + "\nWith message: " + message);
  }
}
