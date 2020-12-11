package com.orientation.practice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Url {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String URL;
  private String alias;
  private long secretCode;

  public Url(String URL, String alias) {
    this.URL = URL;
    this.alias = alias;
  }
}
