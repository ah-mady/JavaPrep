package com.reddit.demo.services;

import com.reddit.demo.models.Vote;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

  void setVote(Vote vote);

}
