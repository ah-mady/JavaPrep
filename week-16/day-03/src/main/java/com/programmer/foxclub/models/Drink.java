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
