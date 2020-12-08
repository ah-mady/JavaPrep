package com.reddit.demo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int rating;
  private String title;
  private String url;

  @OneToMany(mappedBy = "post")
  private List<Vote> votes = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post() {
  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int vote) {
    this.rating = vote;
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

  public List<Vote> getVotes() {
    return votes;
  }

  public void setVotes(List<Vote> votes) {
    this.votes = votes;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
