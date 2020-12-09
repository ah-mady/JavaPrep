package com.reddit.demo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Post implements Comparable<Post> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int rating;
  private String title;
  private String url;
  private LocalDateTime creationDate;
  private long likes;

  @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
  private List<Vote> votes = new ArrayList<>();

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post() {
    this.creationDate = LocalDateTime.now();
  }

  public Post(String title, String url) {
    this.title = title;
    this.url = url;
    this.creationDate = LocalDateTime.now();
  }

  public void like() {
    this.likes++;
  }

  public void dislike() {
    this.likes--;
  }

  @Override
  public int compareTo(Post other) {
    return (int) (other.likes - likes);
  }
}
