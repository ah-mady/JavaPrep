package com.backend.api.frontend.services;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import java.util.Arrays;
import java.util.stream.IntStream;
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

  @Override
  public AppendA appendLetterA(String appendTo) {
    AppendA appendObject = new AppendA();
    appendObject.setAppended(appendTo + "a");
    return appendObject;
  }

  @Override
  public DoUntil doUntil(String action, DoUntil until) {
    if (until.getUntil() == null) {
      until.setError("Please provide a number!");
      return until;
    }

    if (action.equals("sum")) {
      int addition = 0;
      for (int i = 1; i <= until.getUntil(); i++) {
        addition += i;
      }
      until.setResult(addition);

    } else if (action.equals("factor")) {
      int findFactor = 1;

      for (int i = 1; i <= until.getUntil(); i++) {
        findFactor *= i;
      }
      until.setResult(findFactor);
    }
    return until;
  }

  @Override
  public ArrayHandler arrayHandler(String what, int[] numbers) {
    ArrayHandler arrayHandlerObject = new ArrayHandler();
    if (what == null) {
      arrayHandlerObject.setError("Please provide what to do with the numbers!");
      return arrayHandlerObject;
    } else if (numbers == null) {
      arrayHandlerObject.setError("Please provide numbers to do the math!");
      return arrayHandlerObject;
    }

    switch (what) {
      case "sum":
        int sumResult = IntStream.of(numbers).sum();
//        arrayHandlerObject.setWhat("sum");
        arrayHandlerObject.setResult(sumResult);
        break;
      case "multiply":
        int multiplicationResult = 1;
        for (int i = 0; i < numbers.length; i++) {
          multiplicationResult = numbers[i] * numbers[i + 1];
        }
        arrayHandlerObject.setResult(multiplicationResult);
        break;
      case "double":
        int[] doubleResult = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          doubleResult[i] = numbers[i] * 2;
        }
        arrayHandlerObject.setNumbers(doubleResult);
        break;
    }

    return arrayHandlerObject;
  }
}
