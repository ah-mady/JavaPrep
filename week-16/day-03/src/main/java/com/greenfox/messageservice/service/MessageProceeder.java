package com.greenfox.messageservice.service;

import org.springframework.stereotype.Service;

@Service
public class MessageProceeder {

  private MessageService messageService;

  public MessageProceeder(MessageService messageService) {
    this.messageService = messageService;
  }

  public String processMessage(String message, String email) {
    return messageService.sendMessage(message, email);
  }

}
