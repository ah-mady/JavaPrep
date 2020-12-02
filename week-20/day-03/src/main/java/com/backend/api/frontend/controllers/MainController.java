package com.backend.api.frontend.controllers;

import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.services.MainServices;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private MainServices mainServices;

  public MainController(MainServices mainServices) {
    this.mainServices = mainServices;
  }

  @GetMapping()
  public String frontEnd() {
    return "index";
  }

  @GetMapping("/doubling")
  public ResponseEntity<Double> doubling(@RequestParam(required = false) Integer input) {
    Double doubleObject = mainServices.doubleValue(input);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(doubleObject);
  }

}
