package com.todoapp.demo.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

  private String token;

  public AuthResponse() {
  }
}
