package com.programmer.foxclub.controllers;

import com.programmer.foxclub.models.Drink;
import com.programmer.foxclub.models.Food;
import com.programmer.foxclub.models.Fox;
import com.programmer.foxclub.services.FoxService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private FoxService foxService;
  private String currentlyLoggedFox;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/")
  public String homePage(Model model, @RequestParam(required = false) String name) {
    if (name == null) {
      return "redirect:/login";
    }
    Fox myFox = this.foxService.getFoxName(name);
    model.addAttribute("myFox", myFox);
    model.addAttribute("name", name);
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@RequestParam(required = false) String name) {
    foxService.addFox(name);
    currentlyLoggedFox = name;
    return "redirect:/?name=" + name;
  }

  @GetMapping("/nutritionStore")
  public String nutritionStore(@RequestParam String name, Model model){
    List<Food> foodList = Arrays.asList(Food.values());
    List<Drink> drinkList = Arrays.asList(Drink.values());

    model.addAttribute("name", foxService.getFoxName(name).getName());
    model.addAttribute("foodList", foodList);
    model.addAttribute("drinkList", drinkList);
  return "nutritionStore";
  }

  @PostMapping("/nutritionStore")
  public String updateNutrition(@RequestParam String name,
                                @ModelAttribute Food food,
                                @ModelAttribute Drink drink){
    Fox myFox = foxService.getFoxName(name);
    myFox.setFood(Food.valueOf(food.getFoodName()));
    myFox.setDrink(Drink.valueOf(drink.getDrinkName()));

    return "redirect:/" + name;
  }

}
