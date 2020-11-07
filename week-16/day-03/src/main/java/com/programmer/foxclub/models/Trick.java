package com.programmer.foxclub.models;

import java.util.Arrays;
import java.util.Optional;

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

  public static Trick getValue(String trickName){
    Optional<Trick> trickStream = Arrays.stream(Trick.values())
        .filter(e-> e.trickName.equals(trickName))
        .findFirst();
    return trickStream.orElse(null);
  }

  public void setTrickName(String trickName) {
    this.trickName = trickName;
  }

  @Override
  public String toString() {
    return trickName;
  }
}
