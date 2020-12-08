package com.reddit.demo.controllers;

import com.reddit.demo.models.Post;
import com.reddit.demo.services.PostService;
import com.reddit.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

  private PostService postService;
  private UserService userService;

  public PostController(PostService postService, UserService userService) {
    this.postService = postService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String homepage(Model model) {
    if (userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("posts", postService.findAll());
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    return "homepage";
  }

  @GetMapping("/submitPost")
  public String newPost(Model model) {
    model.addAttribute("posts", postService.findAll());
    return "submitPost";
  }

  @PostMapping("/submitPost")
  public String postSubmission(@ModelAttribute Post posts) {
    postService.save(posts);
    return "redirect:/";
  }

  @GetMapping("/{id}/postDetail")
  public String posts(Model model, @PathVariable Long id) {
    model.addAttribute("post", postService.findById(id));
    return "postDetails";
  }
}
