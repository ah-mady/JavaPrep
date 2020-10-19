package com.webshop.basicwebshop.controller;

import com.webshop.basicwebshop.model.ShopItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
