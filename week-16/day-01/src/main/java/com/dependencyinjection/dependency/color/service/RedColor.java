package com.dependencyinjection.dependency.color.service;

import org.springframework.stereotype.Service;

@Service
public class RedColor implements MyColor{
  @Override
  public void printColor() {
    System.out.println("It is Red in color ...");
  }
}
