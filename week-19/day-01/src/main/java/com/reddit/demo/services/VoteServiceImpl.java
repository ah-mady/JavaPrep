package com.reddit.demo.services;

import com.reddit.demo.models.User;
import com.reddit.demo.models.Vote;
import com.reddit.demo.repositories.UserRepository;
import com.reddit.demo.repositories.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

  private VoteRepository voteRepository;
  private UserRepository userRepository;
//  private Vote vote;

  public VoteServiceImpl(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public void setVote(Vote vote) {
    voteRepository.save(vote);
  }

  @Override
  public void upVote(Long id) {
    User user = new User();
    Vote vote = new Vote();
    voteRepository.upVote(id);
//    vote = new Vote(true, userRepository.findById(id).get());
  }

  @Override
  public void downVote(Long id) {
    voteRepository.downVote(id);
  }

}
