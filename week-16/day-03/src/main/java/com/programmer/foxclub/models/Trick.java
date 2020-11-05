package com.programmer.foxclub.models;

public enum Trick {
  HTML("write HTML"),
  JAVA("code in Java"),
  PYTHON("code in Python"),
  CSS("style in CSS");

  private String trickName;

  Trick(String trickName) {
    this.trickName = trickName;
  }

  public String getTrickName() {
    return trickName;
  }

  public void setTrickName(String trickName) {
    this.trickName = trickName;
  }

  @Override
  public String toString() {
    return trickName;
  }
}
