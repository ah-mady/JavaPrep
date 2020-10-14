package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {

  private AtomicLong atomicLong = new AtomicLong(1);
  private String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
      "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
      "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
      "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};


  @GetMapping("/web/greeting")
  public String greeting(Model model,
                         @RequestParam(value = "name", required = false, defaultValue = "World") String name,
                         @RequestParam(value = "color", required = false) String color,
                         @RequestParam(value = "size", required = false, defaultValue = "24") int size) {
    String hello = hellos[((int) (Math.random() * hellos.length - 1) + 1)];
    model.addAttribute("hello", hello);
    model.addAttribute("color", color);
    model.addAttribute("size", size);
    model.addAttribute("name", name);
    model.addAttribute("counter", atomicLong.getAndIncrement());
    return "greeting";
  }
}
