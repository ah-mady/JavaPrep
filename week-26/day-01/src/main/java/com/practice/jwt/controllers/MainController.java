package com.practice.jwt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping({"/hello"})
  public String hello(){
    String s = "Hello World";
    return s;
  }

}
