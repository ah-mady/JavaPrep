package com.programmer.foxclub.models;

import java.util.Arrays;
import java.util.Optional;

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

  public static Drink getValue(String drinkName) {

    Optional<Drink> drinkStream = Arrays.stream(Drink.values())
        .filter(e -> e.drinkName.equals(drinkName))
        .findFirst();
    return drinkStream.orElse(null);

//    for (Drink drink: Drink.values()) {
//      if (drink.drinkName.equals(drinkName)){
//        return drink;
//      }
//    }
//    return null;
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
