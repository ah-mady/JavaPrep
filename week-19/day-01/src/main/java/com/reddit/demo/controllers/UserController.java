package com.reddit.demo.controllers;

import com.reddit.demo.models.User;
import com.reddit.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  private User currentlyLogged;
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String logIn(Model model){
    model.addAttribute("invalidLogin", false);
    return "login";
  }

  @PostMapping("/login")
  public String logInSubmit(@RequestParam String userName,
                            @RequestParam String password,
                            Model model){
    if (userService.validateCredential(userName,password)){
      this.currentlyLogged = userService.fetchUser(userName,password);
      model.addAttribute("isLogged", true);
      return "redirect:/";
    } else{
      model.addAttribute("invalidLogin", true);
      return "login";
    }
  }

  @GetMapping("/logout")
  public String logOut(){
    userService.logout();
    return "login";
  }

  @GetMapping("/createUser")
  public String createUser(){
     return "createUser";
  }

  @PostMapping("/createUser")
  public String createUserSubmit(@ModelAttribute User user){
    userService.save(user);
    return "login";
  }

}
