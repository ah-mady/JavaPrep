package com.greenfox.messageservice.service;

import org.springframework.stereotype.Service;

@Service
public interface MessageService {
  String sendMessage(String message, String email);
}
