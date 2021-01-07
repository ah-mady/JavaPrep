package com.todoapp.demo.models.dto;

import com.todoapp.demo.models.TodoEntity;
import com.todoapp.demo.models.UserEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntityDto {
  private String username;
  private String password;
  private List<TodoEntity> todoListDto = new ArrayList<>();

  public UserEntityDto() {
  }
}
