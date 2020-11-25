package com.reddit.demo.services;

import com.reddit.demo.models.Reddit;
import com.reddit.demo.repositories.RedditRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RedditServiceImp implements RedditService{

  RedditRepository redditRepository;

  public RedditServiceImp(RedditRepository redditRepository) {
    this.redditRepository = redditRepository;
  }

  @Override
  public List<Reddit> findAll() {
    return redditRepository.findAll();
  }

  @Override
  public void save(Reddit posts) {
    redditRepository.save(posts);
  }

  @Override
  public Reddit findById(Long id) {
    return redditRepository.findById(id).orElse(null);
  }

  @Override
  public void upVote(Long id) {
//    Reddit reddit = redditRepository.getOne(id);
//    reddit.setVote(reddit.getVote() + 1);
//    redditRepository.save(reddit);
    redditRepository.upVote(id);
  }

  @Override
  public void downVote(Long id) {
//    Reddit reddit = redditRepository.getOne(id);
//    reddit.setVote(reddit.getVote() - 1);
//    redditRepository.save(reddit);
    redditRepository.downVote(id);
  }
}
