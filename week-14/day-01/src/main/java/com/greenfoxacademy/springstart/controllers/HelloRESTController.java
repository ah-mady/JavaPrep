package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {

  //http://localhost:8080/greeting?name=Ahmed
  @RequestMapping(value = "/greeting")
  public Greeting greeting(@RequestParam ("name") String name){
    return new Greeting( "Hello " + name, 32);
  }
}
