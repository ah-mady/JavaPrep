package com.webshop.basicwebshop.controller;

import com.webshop.basicwebshop.model.ShopItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopItemController {

  List<ShopItem> shopItemList = new ArrayList<>();

  public ShopItemController() {
    shopItemList.add(new ShopItem("adidas", "shoes", 100, 10));
    shopItemList.add(new ShopItem("adidas", "jacket", 200, 11));
    shopItemList.add(new ShopItem("adidas", "shirt", 300, 2));
    shopItemList.add(new ShopItem("adidas", "shoes", 555, 14));
    shopItemList.add(new ShopItem("nike", "shirt", 150, 15));
    shopItemList.add(new ShopItem("nike", "shoes", 100, 16));
    shopItemList.add(new ShopItem("nike", "shoes", 180, 8));
    shopItemList.add(new ShopItem("nike", "jacket", 88, 7));
    shopItemList.add(new ShopItem("nike", "jacket", 199, 6));
    shopItemList.add(new ShopItem("puma", "jacket", 228, 5));
    shopItemList.add(new ShopItem("puma", "shirt", 315, 44));
    shopItemList.add(new ShopItem("oakley", "backpack", 404, 22));
    shopItemList.add(new ShopItem("oakley", "glasses", 379, 6));
    shopItemList.add(new ShopItem("adidas", "glasses", 555, 8));
    shopItemList.add(new ShopItem("hugo boss", "jacket", 555, 0));
    shopItemList.add(new ShopItem("hugo boss", "trousers", 555, 0));
    shopItemList.add(new ShopItem("puma", "shoes", 555, 0));
    shopItemList.add(new ShopItem("adidas", "shirt", 555, 0));
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
  public String searchResult(Model model, @RequestParam String shopItem){
    Predicate<ShopItem> byName = e -> e.getName().toLowerCase().contains(shopItem.toLowerCase());
    Predicate<ShopItem> byDescription = e -> e.getDescription().toLowerCase().contains(shopItem.toLowerCase());

    List<ShopItem> searchedItem = shopItemList.stream()
        .filter(byName.or(byDescription))
        .collect(Collectors.toList());

    model.addAttribute("items", searchedItem);
    return "homepage";
  }


}
