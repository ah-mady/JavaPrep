package com.programmer.foxclub.controller;

import com.programmer.foxclub.model.Fox;
import com.programmer.foxclub.service.FoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;

  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String homePage(Model model, @RequestParam(required = false) String name) {
    if (name == null) {
      return "redirect:/login";
    }
    Fox myFox = this.foxService.getFoxName(name);
    if (myFox != null) {
      model.addAttribute("myFox", myFox);
    } else {
      model.addAttribute("name", name);
      model.addAttribute("errormessage",
          "You have provided a name that has not been used before, add it as a new one!");
    }
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String login(Model model, @RequestParam(required = false) String name) {
    foxService.addFox(name);
    return "redirect:/?name=" + name;
  }

}
