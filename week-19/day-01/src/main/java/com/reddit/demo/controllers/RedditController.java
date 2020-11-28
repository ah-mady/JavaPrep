package com.reddit.demo.controllers;

import com.reddit.demo.models.Reddit;
import com.reddit.demo.services.RedditService;
import com.reddit.demo.services.UserService;
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
  private UserService userService;

  public RedditController(RedditService redditService, UserService userService) {
    this.redditService = redditService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String homepage(Model model) {
    if (userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("posts", redditService.findAll());
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
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
  public String posts(Model model, @PathVariable Long id) {
    model.addAttribute("post", redditService.findById(id));
    return "postDetails";
  }

  @GetMapping("/{id}/increaseVote")
  public String upVote(@PathVariable Long id) {
    redditService.upVote(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/decreaseVote")
  public String downVote(@PathVariable Long id) {
    redditService.downVote(id);
    return "redirect:/";
  }


}
