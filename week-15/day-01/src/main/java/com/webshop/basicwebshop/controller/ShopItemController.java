package com.webshop.basicwebshop.controller;

import com.webshop.basicwebshop.model.ShopItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopItemController {

  List<ShopItem> shopItemList = new ArrayList<>();

  public ShopItemController() {
    shopItemList.add(new ShopItem("adidas", "shoes", "running shoes", 100, 10));
    shopItemList.add(new ShopItem("adidas", "lifestyle", "formel1 jacket", 200, 11));
    shopItemList.add(new ShopItem("adidas", "basketball", "shirt", 300, 2));
    shopItemList.add(new ShopItem("adidas", "football", "shoes", 555, 14));
    shopItemList.add(new ShopItem("nike", "running", "shirt", 150, 15));
    shopItemList.add(new ShopItem("nike", "basketball", "shoes", 100, 16));
    shopItemList.add(new ShopItem("nike", "lifestyle", "shoes", 180, 8));
    shopItemList.add(new ShopItem("nike", "lifestyle", "jacket", 88, 7));
    shopItemList.add(new ShopItem("nike", "baseball", "jacket", 199, 6));
    shopItemList.add(new ShopItem("puma", "lifestyle", "jacket", 228, 5));
    shopItemList.add(new ShopItem("puma", "football", "shirt", 315, 44));
    shopItemList.add(new ShopItem("oakley", "lifestyle", "backpack", 404, 22));
    shopItemList.add(new ShopItem("oakley", "lifestyle", "glasses", 379, 6));
    shopItemList.add(new ShopItem("adidas", "cycling", "glasses", 555, 8));
    shopItemList.add(new ShopItem("hugo boss", "lifestyle", "jacket", 555, 0));
    shopItemList.add(new ShopItem("hugo boss", "lifestyle", "trousers", 555, 0));
    shopItemList.add(new ShopItem("puma", "running", "shoes", 555, 0));
    shopItemList.add(new ShopItem("adidas", "golf", "shirt", 555, 0));
  }

  @GetMapping("/webshop")
  public String homepage(Model model) {
    model.addAttribute("items", shopItemList);
    return "homepage";
  }

  @GetMapping("/only-available")
  public String onlyAvailableItems(Model model) {
    List<ShopItem> onlyItems = shopItemList.stream()
        .filter(moreQuantityThanZero -> moreQuantityThanZero.getQuantityOfStock() > 0)
        .collect(Collectors.toList());
    model.addAttribute("items", onlyItems);
    return "homepage";
  }

  @GetMapping("/cheapest-first")
  public String cheapestFirst(Model model) {
    List<ShopItem> sortedPrice = shopItemList.stream()
        .sorted(Comparator.comparing(ShopItem::getPrice))
        .collect(Collectors.toList());
    model.addAttribute("items", sortedPrice);
    return "homepage";
  }

  @GetMapping("/contains-nike")
  public String containsNike(Model model) {
    List<ShopItem> containNike = shopItemList.stream()
        .filter(contains -> contains.getName() == "nike")
        .collect(Collectors.toList());
    model.addAttribute("items", containNike);
    return "homepage";
  }

  @GetMapping("/average-stock")
  public String averageStock(Model model) {
    OptionalDouble averageStockPrice = shopItemList.stream()
        .mapToDouble(i -> i.getQuantityOfStock())
        .average();
    model.addAttribute("averageStock", averageStockPrice);
    return "stockAverage";
  }

  //  @GetMapping("/average-stock")
//  public String averageStock(Model model){
//    OptionalDouble averageStockPrice = shopItemList.stream()
//        .mapToDouble(i -> i.getPrice())
//        .average();
//
//    model.addAttribute("averageStock", averageStockPrice);
//    return "stockAverage";
//  }
  @GetMapping("/most-expensive")
  public String mostExpensive(Model model) {
    String expensive = Collections.max(shopItemList, Comparator.comparing(ShopItem::getPrice)).getName();
    model.addAttribute("expensive", expensive);
    return "mostExpensive";
  }

  @PostMapping("/search")
  public String searchResult(Model model, @RequestParam String shopItem) {
    Predicate<ShopItem> byName = e -> e.getName().toLowerCase().contains(shopItem.toLowerCase());
    Predicate<ShopItem> byDescription = e -> e.getDescription().toLowerCase().contains(shopItem.toLowerCase());
    Predicate<ShopItem> byType = e -> e.getType().toLowerCase().contains(shopItem.toLowerCase());

    List<ShopItem> searchedItem = shopItemList.stream()
        .filter(byName.or(byDescription).or(byType))
        .collect(Collectors.toList());

    model.addAttribute("items", searchedItem);
    return "homepage";
  }

  @GetMapping("/more-filters")
  public String moreFilters(Model model) {
    model.addAttribute("items", shopItemList);
    return "more";
  }

  @GetMapping("/filter-by-type")
  public String filterByType(@RequestParam String type, Model model) {
    Predicate<ShopItem> byType = e -> e.getType().toLowerCase().contains(type.toLowerCase());

    List<ShopItem> filterByType = shopItemList.stream()
        .filter(byType)
        .collect(Collectors.toList());

    model.addAttribute("items", filterByType);
    return "more";
  }

  @GetMapping("/lifestyle")
  public String filterLifestyle(Model model) {
    List<ShopItem> containLifestyle = shopItemList.stream()
        .filter(contains -> contains.getType() == "lifestyle")
        .collect(Collectors.toList());
    model.addAttribute("items", containLifestyle);
    return "more";
  }

  @GetMapping("/running")
  public String filterRunning(Model model) {
    List<ShopItem> containNike = shopItemList.stream()
        .filter(contains -> contains.getType() == "running")
        .collect(Collectors.toList());
    model.addAttribute("items", containNike);
    return "more";
  }

  @GetMapping("/euro")
  public String euro(Model model) {
    List<ShopItem> convertToEuro = shopItemList.stream()
        .map(currency -> new ShopItem(currency.getName(), currency.getType(), currency.getDescription(), currency.getPrice() * 0.0028, currency.getQuantityOfStock()))
        .collect(Collectors.toList());
    model.addAttribute("items", convertToEuro);
    return "euro";
  }

  @GetMapping("/original-currency")
  public String originalCurrency(Model model) {
    model.addAttribute("items", shopItemList);
    return "more";
  }

  @PostMapping("/filter-by-price")
  public String filterByPrice(Model model, @RequestParam String operator, @RequestParam int price){
    model.addAttribute("operator", operator);

    List<ShopItem> items = null;

    switch (operator){
      case ("Above"):
        items = shopItemList.stream()
            .filter(i -> i.getPrice() > price)
            .collect(Collectors.toList());
        break;

      case ("Below"):
        items = shopItemList.stream()
            .filter(i -> i.getPrice() < price)
            .collect(Collectors.toList());
        break;

      case ("Exactly"):
        items = shopItemList.stream()
            .filter(i-> i.getPrice() == price)
            .collect(Collectors.toList());
        break;
    }

    model.addAttribute("items", items);
    return "more";
  }

}
