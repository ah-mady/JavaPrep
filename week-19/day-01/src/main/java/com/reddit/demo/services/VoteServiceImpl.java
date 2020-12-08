package com.reddit.demo.services;

import com.reddit.demo.models.Vote;
import com.reddit.demo.repositories.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService{

  private VoteRepository voteRepository;

  public VoteServiceImpl(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public void setVote(Vote vote) {
    voteRepository.save(vote);
  }
}
