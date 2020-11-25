package com.reddit.demo.controllers;

import com.reddit.demo.models.Reddit;
import com.reddit.demo.services.RedditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RedditController {

  private RedditService redditService;

  public RedditController(RedditService redditService) {
    this.redditService = redditService;
  }

  @GetMapping("/")
  public String homepage(Model model) {
    model.addAttribute("posts", redditService.findAll());
    return "homepage";
  }

  @GetMapping("/submitPost")
  public String newPost(Model model) {
    model.addAttribute("posts", redditService.findAll());
    return "submitPost";
  }

  @PostMapping("/submitPost")
  public String postSubmission(@ModelAttribute Reddit posts) {
    redditService.save(posts);
    return "redirect:/";
  }

  @GetMapping("/{id}/postDetail")
  public String posts(Model model, @PathVariable Long id){
    model.addAttribute("post", redditService.findById(id));
    return "postDetails";
  }

  @GetMapping("/increaseVote")
  public String upVote(@RequestParam(name = "id") Long id){
    redditService.upVote(id);
    return "redirect:/";
  }
}
