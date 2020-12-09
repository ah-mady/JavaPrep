package com.reddit.demo.services;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import com.reddit.demo.models.Vote;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

  void setVote(Vote vote);

  Vote returnVoteByPostAndUser(Post post, User loggedUser);

  List<Vote> returnAllVotesByUser(User loggedUser);

}
