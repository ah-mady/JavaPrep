package com.backend.api.frontend.services;

import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
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

  @Override
  public Greeter greeter(String name, String title) {
    Greeter greeterObject = new Greeter();
    if (name == null && title == null) {
      greeterObject.setError("Please provide a name and a title!");
    } else if (name == null) {
      greeterObject.setError("Please provide a name!");
    } else if (title == null) {
      greeterObject.setError("Please provide a title!");
    } else {
      greeterObject.setName(name);
      greeterObject.setTitle(title);
      greeterObject.setWelcome_message("Oh, hi there " + name + ", my dear " + title + "!");
    }
    return greeterObject;
  }
}
