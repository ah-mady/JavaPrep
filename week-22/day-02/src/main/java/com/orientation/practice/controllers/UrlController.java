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
  public String homepage(Model model) {
    Url newUrlObj = new Url();
    model.addAttribute("url", newUrlObj);
    return "homepage";
  }

  @PostMapping("/save-link")
  public String submitUrl(@ModelAttribute Url url, Model model) {
    if (urlService.validateAlias(url.getAlias())) {
      model.addAttribute("url", url);
      urlService.save(url);
      return "savedAlias";
    } else {
      model.addAttribute("existingAlias", true);
      return "homepage";
    }
  }

}
