package com.backend.api.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppendA {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String appended;

}
