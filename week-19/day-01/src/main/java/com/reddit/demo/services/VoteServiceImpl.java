package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import com.reddit.demo.models.Vote;
import com.reddit.demo.repositories.UserRepository;
import com.reddit.demo.repositories.VoteRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

  private VoteRepository voteRepository;

  public VoteServiceImpl(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public void setVote(Vote vote) {
    voteRepository.save(vote);
  }

  @Override
  public Vote returnVoteByPostAndUser(Post post, User loggedUser) {
    return voteRepository.returnVoteByPostAndUser(post, loggedUser);
  }

  @Override
  public List<Vote> returnAllVotesByUser(User loggedUser) {
    return voteRepository.returnAllVotesByUser(loggedUser);
  }

//  @Override
//  public void upVote(Long id) {
//    User user = new User();
//    Vote vote = new Vote();
//    voteRepository.upVote(id);
////    vote = new Vote(true, userRepository.findById(id).get());
//  }
//
//  @Override
//  public void downVote(Long id) {
//    voteRepository.downVote(id);
//  }

}
