package com.backend.api.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoUntil {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String action;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer until;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer result;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String error;

}
