package com.backend.api.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ArrayHandler {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String what;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private int[] numbers;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer result;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String error;

  public ArrayHandler() {
  }

  public String getWhat() {
    return what;
  }

  public void setWhat(String what) {
    this.what = what;
  }

  @JsonProperty(value = "result")
  public int[] getNumbers() {
    return numbers;
  }

  @JsonProperty(value = "numbers")
  public void setNumbers(int[] numbers) {
    this.numbers = numbers;
  }

  public void setNumbers2(int[] numbers) {
    this.numbers = numbers;
  }

  public Integer getResult() {
    return result;
  }

  public void setResult(Integer result) {
    this.result = result;
  }


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
