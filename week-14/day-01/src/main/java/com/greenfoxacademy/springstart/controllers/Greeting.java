package com.greenfoxacademy.springstart.controllers;

public class Greeting {
  private long greetCount;
  private String contentField;

  public Greeting(String contentField, long greetCount) {
    this.greetCount = greetCount;
    this.contentField = contentField;
  }

  public long getGreetCount() {
    return greetCount;
  }

  public String getContentField() {
    return contentField;
  }
}
