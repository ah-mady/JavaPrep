package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.repositories.RedditRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {

  RedditRepository redditRepository;

  public PostServiceImp(RedditRepository redditRepository) {
    this.redditRepository = redditRepository;
  }

  @Override
  public List<Post> findAll() {
    return redditRepository.findAll();
  }

  @Override
  public void save(Post posts) {
    redditRepository.save(posts);
  }

  @Override
  public Post findById(Long id) {
    return redditRepository.findById(id).orElse(null);
  }

  @Override
  public void upVote(Long id) {
//    Post reddit = redditRepository.getOne(id);
//    reddit.setVote(reddit.getVote() + 1);
//    redditRepository.save(reddit);
    redditRepository.upVote(id);
  }

  @Override
  public void downVote(Long id) {
//    Post reddit = redditRepository.getOne(id);
//    reddit.setVote(reddit.getVote() - 1);
//    redditRepository.save(reddit);
    redditRepository.downVote(id);
  }
}
