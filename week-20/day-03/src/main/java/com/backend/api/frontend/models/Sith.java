package com.backend.api.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Sith {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String sith;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String sithText;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String error;

  public Sith(String sithText) {
    this.sithText = sithText;
  }
}
