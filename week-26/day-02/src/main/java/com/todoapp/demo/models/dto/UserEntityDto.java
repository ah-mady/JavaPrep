package com.todoapp.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntityDto {
  private String username;
  private String password;

  public UserEntityDto() {
  }
}
