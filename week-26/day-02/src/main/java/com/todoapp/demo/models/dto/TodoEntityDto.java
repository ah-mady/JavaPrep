package com.todoapp.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoEntityDto {

  private String title;
  private boolean urgent;
  private boolean done;

  public TodoEntityDto() {
  }

}
