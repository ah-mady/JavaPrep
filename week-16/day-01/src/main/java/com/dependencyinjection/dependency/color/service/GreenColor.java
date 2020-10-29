package com.dependencyinjection.dependency.color.service;

import org.springframework.stereotype.Service;


public class GreenColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is Green in color ...");
  }
}
