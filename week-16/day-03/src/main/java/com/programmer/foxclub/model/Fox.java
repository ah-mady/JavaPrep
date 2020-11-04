package com.programmer.foxclub.model;

import java.util.ArrayList;
import java.util.List;

public class Fox {
  private String name;
  private Food food;
  private Drink drink;
  private List<Trick> trickList = new ArrayList<>();

  public Fox(String name) {
    this.name = name;
    this.food = Food.BIRYANI;
    this.drink = Drink.TEA;
    this.trickList.add(Trick.JAVA);
    this.trickList.add(Trick.HTML);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Food getFood() {
    return food;
  }

  public void setFood(Food food) {
    this.food = food;
  }

  public Drink getDrink() {
    return drink;
  }

  public void setDrink(Drink drink) {
    this.drink = drink;
  }

  public List<Trick> getTrickList() {
    return trickList;
  }

  public void setTrickList(List<Trick> trickList) {
    this.trickList = trickList;
  }
}
