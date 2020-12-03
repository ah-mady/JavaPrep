package com.backend.api.frontend.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LogEntry {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDateTime createdAt;
  private String endpoint;
  private String data;

  public LogEntry() {
    this.createdAt = LocalDateTime.now();
  }

  public LogEntry(String endpoint, String data) {
    this.createdAt = LocalDateTime.now();
    this.endpoint = endpoint;
    this.data = data;
  }
}
