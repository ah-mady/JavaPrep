package com.connectionwith.mysql.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private boolean isUrgent;
  private boolean isDone;

  public ToDo() {
  }

  public ToDo(String title) {
    this.title = title;
    this.isUrgent = false;
    this.isDone = false;
  }

  public ToDo(Long id, String title) {
    this.id = id;
    this.title = title;
    this.isUrgent = false;
    this.isDone = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isUrgent() {
    return isUrgent;
  }

  public void setIsUrgent(boolean urgent) {
    this.isUrgent = urgent;
  }

  public boolean isDone() {
    return isDone;
  }

  public void setIsDone(boolean done) {
    this.isDone = done;
  }

  @Override
  public String toString() {
    return title;
  }
}
