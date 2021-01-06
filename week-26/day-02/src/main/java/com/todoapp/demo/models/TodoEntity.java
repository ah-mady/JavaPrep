package com.todoapp.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TodoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private boolean urgent;
  private boolean done;

  public TodoEntity() {
  }

  public TodoEntity(String title) {
    this.title = title;
    this.urgent = false;
    this.done = false;
  }
}
