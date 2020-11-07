package com.programmer.foxclub.models;

import java.util.Arrays;
import java.util.Optional;

public enum Food {
  PIZZA("pizza"),
  BIRYANI("biryani"),
  TIKKAMASALA("tikka masala"),
  SALAD("salad"),
  BURGER("burger");

  private String foodName;

  Food() {
  }

  Food(String foodName) {
    this.foodName = foodName;
  }

  public static Food getValue(String foodName){
    Optional<Food> foodStream = Arrays.stream(Food.values())
        .filter(e -> e.foodName.equals(foodName))
        .findFirst();
    return foodStream.orElse(null);
  }

  public String getFoodName() {
    return foodName;
  }

  public void setFoodName(String foodName) {
    this.foodName = foodName;
  }

  @Override
  public String toString() {
    return foodName;
  }
}
