package com.backend.api.frontend.services;

import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import org.springframework.stereotype.Service;

@Service
public interface MainServices {
  Double doubleValue(Integer valueToBeDoubled);

  Greeter greeter(String name, String title);
}