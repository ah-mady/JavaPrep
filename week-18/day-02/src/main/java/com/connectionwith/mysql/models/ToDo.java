package com.connectionwith.mysql.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ToDo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private boolean isUrgent;
  private boolean isDone;
  private String description;
  @ManyToOne
  @JoinColumn(name = "assignee_Id")
  private Assignee assignee;

  //  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate createdAt;

  //  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dueDate;

  public ToDo() {
    this.createdAt = LocalDate.now();
  }

  public ToDo(String title, boolean isUrgent, boolean isDone) {
    this.title = title;
    this.isUrgent = isUrgent;
    this.isDone = isDone;
    this.createdAt = LocalDate.now();
  }

  public ToDo(String title) {
    this(title, false, false);
    this.createdAt = LocalDate.now();
  }

  public ToDo(String title, boolean isUrgent) {
    this(title, isUrgent, false);
  }

  public ToDo(String title, String description) {
    this(title, false, false);
    this.description = description;
    this.createdAt = LocalDate.now();
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  @Override
  public String toString() {
    return title;
  }
}
