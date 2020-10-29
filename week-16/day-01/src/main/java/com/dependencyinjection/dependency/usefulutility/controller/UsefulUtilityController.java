package com.dependencyinjection.dependency.usefulutility.controller;

import com.dependencyinjection.dependency.usefulutility.service.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulUtilityController {
  UtilityService utilityService;

  public UsefulUtilityController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }

  @GetMapping("/useful")
  public String homepage () {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String backgroundColor(Model model){
    model.addAttribute("color", "background-color: " + utilityService.randomColor() + ";");
    return "colored";
  }

  @GetMapping("/useful/email")
  public String emailValidation(Model model, @RequestParam(value = "email", required = false) String email){
    String emailResponse;
    String formatResponse;

    if (utilityService.validEmail(email)){
      emailResponse = "<p style='color:green;'>" + email + " is a valid email address </p>";
      formatResponse = "background-color: green";
    } else {
      emailResponse = "<p style='color:red;'>" + email + " is NOT a valid email address </p>";
      formatResponse = "background-color: red";
    }

    model.addAttribute("emailResponse", emailResponse);
    model.addAttribute("formatResponse", formatResponse);

    return "useful";
  }

}
