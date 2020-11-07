package com.programmer.foxclub.models;

public enum Drink {
  WATER("water"),
  BEER("beer"),
  VODKA("vodka"),
  TEA("tea"),
  LEMONADE("lemonade"),
  JUICE("juice");

  private String drinkName;

  Drink() {
  }

  Drink(String drinkName) {
    this.drinkName = drinkName;
  }

  public static Drink getValue(String drinkName){
    for (Drink drink: Drink.values()) {
      if (drink.drinkName.equals(drinkName)){
        return drink;
      }
    }
    return null;
  }

  public String getDrinkName() {
    return drinkName;
  }

  public void setDrinkName(String drinkName) {
    this.drinkName = drinkName;
  }

  @Override
  public String toString() {
    return drinkName;
  }
}
