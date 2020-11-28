package com.reddit.demo.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 12, unique = true)
  private String userName;

  @Column(length = 12)
  private String password;

  @DateTimeFormat(pattern = "yyyy/MMM/dd HH:mm")
  private LocalDateTime registeredAt;

  @Column(name = "is_logged")
  private Boolean isLogged;

  public User() {
    this.registeredAt = LocalDateTime.now();
    this.isLogged = false;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getLogged() {
    return isLogged;
  }

  public void setLogged(Boolean logged) {
    isLogged = logged;
  }
}
