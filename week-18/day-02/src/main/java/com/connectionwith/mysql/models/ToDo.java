package com.connectionwith.mysql.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private boolean isUrgent;
  private boolean isDone;

  @ManyToOne
  @JoinColumn(name = "assignee_Id")
  private Assignee assignee;

  public ToDo() {
  }

  public ToDo(String title, boolean isUrgent, boolean isDone) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
  }

  public ToDo(String title) {
    this(title, false,false);
  }

  public ToDo(String title, boolean isUrgent) {
    this(title, isUrgent,false);
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

  public boolean getIsUrgent() {
    return isUrgent;
  }

  public void setIsUrgent(boolean urgent) {
    this.isUrgent = urgent;
  }

  public boolean getIsDone() {
    return isDone;
  }

  public void setIsDone(boolean done) {
    this.isDone = done;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }

  @Override
  public String toString() {
    return title;
  }
}
