package com.backend.api.frontend.services;

import com.backend.api.frontend.models.Double;
import org.springframework.stereotype.Service;

@Service
public class MainServicesImpl implements MainServices {
  @Override
  public Double doubleValue(Integer valueToBeDoubled) {
    Double doubleObject = new Double();
    if (valueToBeDoubled == null) {
      doubleObject.setError("Please provide an input!");
    } else {
      Integer doubleValue = valueToBeDoubled * 2;
      doubleObject.setReceived(valueToBeDoubled);
      doubleObject.setResult(doubleValue);
    }
    return doubleObject;
  }
}
