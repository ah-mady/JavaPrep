package com.reddit.demo.controllers;

import com.reddit.demo.repositories.VoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VoteController {

  private VoteRepository voteRepository;

  public VoteController(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @GetMapping("/{id}/increaseVote")
  public String upVote(@PathVariable Long id) {
    voteRepository.upVote(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/decreaseVote")
  public String downVote(@PathVariable Long id) {
    voteRepository.downVote(id);
    return "redirect:/";
  }
}
