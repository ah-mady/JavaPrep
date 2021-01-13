package com.todoapp.demo.models.dto;

import com.todoapp.demo.models.TodoEntity;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserEntityDto {
  @NotEmpty
  private String username;
  @NotEmpty
  private String password;
  private String role;
  private List<TodoEntity> todoListDto = new ArrayList<>();

  public UserEntityDto() {
  }
}
