package com.reddit.demo.services;

import com.reddit.demo.models.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

  void setVote(Vote vote);

  void upVote(Long id);

  void downVote(Long id);

}
