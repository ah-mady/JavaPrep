package com.orientation.practice.controllers;

import com.orientation.practice.models.Url;
import com.orientation.practice.services.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UrlController {
  private UrlService urlService;

  public UrlController(UrlService urlService) {
    this.urlService = urlService;
  }

  @GetMapping("/")
  public String homepage(Model model){
    model.addAttribute("url", urlService.findAll());
    return "homepage";
  }

  @PostMapping("/save-link")
  public String submitUrl(@ModelAttribute Url url){
    urlService.setSecretCode(urlService.generateSecretCode());
    return "redirect:/";
  }

}
