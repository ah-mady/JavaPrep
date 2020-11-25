package com.reddit.demo.services;

import com.reddit.demo.models.Reddit;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface RedditService {

  List<Reddit> findAll();

  void save(Reddit posts);

  Reddit findById(Long id);

  void upVote(Long id);
}
