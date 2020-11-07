package com.programmer.foxclub.models;

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
    for (Food food: Food.values()) {
      if (food.foodName.equals(foodName)){
        return food;
      }
    }
    return null;
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
