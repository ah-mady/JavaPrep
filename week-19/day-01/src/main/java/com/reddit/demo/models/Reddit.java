package com.reddit.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reddit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int vote;
  private String title;
  private String url;

  public Reddit() {
  }

  public Reddit(String title, String url) {
    this.title = title;
    this.url = url;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getVote() {
    return vote;
  }

  public void setVote(int vote) {
    this.vote = vote;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String description) {
    this.title = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
