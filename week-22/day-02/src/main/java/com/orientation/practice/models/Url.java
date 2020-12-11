package com.orientation.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JsonIgnore
  private String secretCode;
  private int hitCount;

  public Url(String URL, String alias) {
    this.URL = URL;
    this.alias = alias;
  }
}
