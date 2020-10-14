package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FizzBuzzWoofController {

  AtomicLong atomicLong = new AtomicLong(1);

  @GetMapping("/fizz")
  public String countWithFizzBuzzWoof(Model model) {
    long counter = atomicLong.getAndIncrement();
    String number = "";
    int size = 16;
    if (counter % 3 == 0) {
      number += "Fizz";
    }
    if (counter % 5 == 0) {
      number += "Buzz";
    }
    if (counter % 7 == 0) {
      number += "Woof";
    }
    if (!number.isEmpty()) {
      switch (number.length()) {
        case 4:
          size = 24;
          break;
        case 8:
          size = 48;
          break;
        case 12:
          size = 72;
          break;
      }
    } else {
      number = String.valueOf(counter);
    }
    model.addAttribute("number", number);
    model.addAttribute("size", size);
    return "fizzbuzz";
  }
}
