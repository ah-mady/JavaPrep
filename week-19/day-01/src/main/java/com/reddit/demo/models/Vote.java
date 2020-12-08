package com.reddit.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vote {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private boolean isVoted;

  private long votedByUserId;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  public Vote() {
  }

  public Vote(boolean isVoted, long votedByUserId) {
    this.isVoted = isVoted;
    this.votedByUserId = votedByUserId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isVoted() {
    return isVoted;
  }

  public void setVoted(boolean voted) {
    isVoted = voted;
  }

  public long getVotedByUserId() {
    return votedByUserId;
  }

  public void setVotedByUserId(long votedByUserId) {
    this.votedByUserId = votedByUserId;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}
