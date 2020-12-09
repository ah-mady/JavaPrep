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

  private int upVote;

  @ManyToOne
  @JoinColumn(name = "voter_id")
  private User votedByUserId;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  public Vote() {
  }

  public Vote(User votedByUserId) {
    this.votedByUserId = votedByUserId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getVotedByUserId() {
    return votedByUserId;
  }

  public void setVotedByUserId(User votedByUserId) {
    this.votedByUserId = votedByUserId;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public int getUpVote() {
    return upVote;
  }

  public void setUpVote(int score) {
    this.upVote = score;
  }
}
