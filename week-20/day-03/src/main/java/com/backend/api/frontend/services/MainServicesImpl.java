package com.backend.api.frontend.services;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import com.backend.api.frontend.models.Sith;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
        arrayHandlerObject.setNumbers(new int[] {sumResult});
        return arrayHandlerObject;
      case "multiply":
        int multiplicationResult = 1;
        for (int value : numbers) {
          multiplicationResult *= value;
        }
        arrayHandlerObject.setNumbers(new int[] {multiplicationResult});
        return arrayHandlerObject;
      case "double":
        int[] doubleResult = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
          doubleResult[i] = numbers[i] * 2;
        }
        arrayHandlerObject.setNumbers(doubleResult);
        return arrayHandlerObject;
    }
    return arrayHandlerObject;
  }

//  @Override
//  public Sith sith(String sith) {
//    Random random = new Random();
//    List<String> randomSithWords = Arrays.asList("Arrgh.", "Uhmm.", "Err..err.err.");
//    List<String> sentenceWords = Arrays.asList(sith.split("\\."));
//    StringBuilder sithText = new StringBuilder();
//
//    for (int i = 0; i < sentenceWords.size(); i++) {
//      List<String> words = Arrays.asList(sentenceWords.get(i).split(" "));
//
////      words.set(i, words.get(0).substring(0, 1) + words.get(0).substring(1));
////      words.set(i, words.get(1).substring(0, 1) + words.get(1).substring(1));
//
//      for (int j = 0; j < words.size(); j += 2) {
//        String temp = words.get(j);
//        if (words.get(j+1).isEmpty()){
//          break;
//        } else {
//
//          words.set(j, words.get(j + 1));
//          sithText.append(words.get(j)).append(" ");
//          words.set(j + 1, temp);
//          sithText.append(words.get(j + 1)).append(" ");
//        }
//      }
//
//      if (words.size() % 2 != 0) {
//        sithText.append(words.get(words.size() - 1));
//      }
//
//      if (i == sentenceWords.size() - 1) {
//        sithText.append(".");
//      } else {
//        sithText.append(". ");
//      }
//
//      if (i == sentenceWords.size() - 1) {
//        sithText.append(" ").append(randomSithWords.get(random.nextInt(3)));
//      } else {
//        sithText.append(randomSithWords.get(random.nextInt(3))).append(" ");
//      }
//    }
//    return new Sith(sithText.toString());
//  }
}
