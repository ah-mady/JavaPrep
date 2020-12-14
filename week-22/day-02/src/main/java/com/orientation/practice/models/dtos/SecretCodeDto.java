package com.orientation.practice.models.dtos;

import com.orientation.practice.models.Url;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class SecretCodeDto {
  private String secretCode;

//  public SecretCodeDto(Url url) {
//    this.secretCode = url.getSecretCode();
//  }
}
