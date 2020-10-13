package com.greenfoxacademy.springstart.controllers;

public class Greeting {
  private long id;
  private String contentField;

  public Greeting(String contentField, long id) {
    this.id = id;
    this.contentField = contentField;
  }

  public long getId() {
    return id;
  }

  public String getContentField() {
    return contentField;
  }
}
