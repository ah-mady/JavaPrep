package com.reddit.demo.controllers;

import com.reddit.demo.models.Post;
import com.reddit.demo.models.User;
import com.reddit.demo.repositories.VoteRepository;
import com.reddit.demo.services.PostService;
import com.reddit.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VoteController {

  private VoteRepository voteRepository;
  private PostService postService;
  private UserService userService;

  public VoteController(VoteRepository voteRepository, PostService postService, UserService userService) {
    this.voteRepository = voteRepository;
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("/{id}/increaseVote")
  public String upVote(@PathVariable Long id) {
//    voteRepository.upVote(id);

    Post likedPost = postService.findById(id);
    User loggedUser = userService.loggedUser();
    postService.likePost(likedPost, loggedUser);

    return "redirect:/";
  }

  @GetMapping("/{id}/decreaseVote")
  public String downVote(@PathVariable Long id) {
//    voteRepository.downVote(id);
    Post dislikedPost = postService.findById(id);
    User loggedUser = userService.loggedUser();
    postService.dislikePost(dislikedPost, loggedUser);
    return "redirect:/";
  }
}
