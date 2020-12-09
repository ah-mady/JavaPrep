package com.backend.api.frontend.services;

import com.backend.api.frontend.models.AppendA;
import com.backend.api.frontend.models.ArrayHandler;
import com.backend.api.frontend.models.DoUntil;
import com.backend.api.frontend.models.Double;
import com.backend.api.frontend.models.Greeter;
import com.backend.api.frontend.models.Sith;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.http.ResponseEntity;
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

  @Override
  public Sith sith(String sith) {
    Random random = new Random();
    List<String> randomSithWords = Arrays.asList("Arrgh.", "Uhmm.", "Err..err.err.");
    List<String> sentenceWords = Arrays.asList(sith.split("\\."));
//    StringBuilder sithText = new StringBuilder();

    for (int i = 0; i < sentenceWords.size(); i++) {
      List<String> words = Arrays.asList(sentenceWords.get(i).split(" "));
      List<String> modifiedWords = new ArrayList<>();

      for (int j = 0; j < words.size(); j += 2) {
        if (words.size() % 2 != 1 || j + 1 != words.size()) {
          modifiedWords.add(words.get(j + 1));
        }
        modifiedWords.add(words.get(j));
      }
      modifiedWords.add(randomSithWords.get(random.nextInt(randomSithWords.size())));
      sentenceWords.set(i, modifiedWords.toString());
    }
    return new Sith(sentenceWords.toString());
  }

//  @Override
//  public ResponseEntity<?> responseSith(String sith) {
////    ObjectMapper objectMapper = new ObjectMapper();
//    try {
////      String text = objectMapper.readTree(sith).get("text").asText();
//      String[] randomSithWords = {"Arrgh.", "Uhmm.", "Hmmm. ", "Oooh. ", "Khmm.. khmm. ", "Err..err.err."};
//      List<String> sentences = Arrays.asList(sith.split("\\."));
//      StringBuilder sithText = new StringBuilder();
//
//      for (String sentence : sentences) {
//        String[] words = sentence.split(" ");
//        for (int i = 0; i < words.length; i += 2) {
//          if (i == 0 && words.length > 1) {
//            words[i + 1] = words[i + 1].substring(0, 1).toUpperCase() + words[i + 1].substring(1);
//            words[i] = words[i].toLowerCase();
//          }
//          if (words.length > i + 1) {
//            String temp = "";
//            temp = words[i];
//            words[i] = words[i + 1];
//            words[i + 1] = temp;
//          }
//        }
//        for (int i = 0; i < words.length; i++) {
//          sithText.append(words[i]);
//          if (i < words.length - 1){
//            sithText.append(" ");
//          } else {
//            sithText.append(". ");
//            sithText.append(randomSithWords[(int) (Math.random() * randomSithWords.length)]);
//          }
//        }
//      }
//      return ResponseEntity.ok().body(new Sith(sithText.toString()));
//    } catch (Exception e) {
//      return ResponseEntity.ok().body(new Error("Feed me some text you have to, " +
//          "padawan young you are. Hmmm."));
//    }
//  }

}
