package example10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  //Create a Fox class with 3 properties:name, color and age Fill a list with at least 5 foxes and:
  //

  public static void main(String[] args) {

    Fox fox1 = new Fox("Poc", "green", 2);
    Fox fox2 = new Fox("Cini", "yellow", 1);
    Fox fox3 = new Fox("Stephy", "brown", 11);
    Fox fox4 = new Fox("Mutyi", "black", 4);
    Fox fox5 = new Fox("Tacsi", "green", 10);

    List<Fox> foxes = Arrays.asList(fox1, fox2, fox3, fox4, fox5);

    //Write a Stream Expression to find the foxes with green color!
    List<Fox> greenFoxList = foxes.stream()
        .filter(fox -> fox.getColor().equals("green"))
        .collect(Collectors.toList());

    System.out.println("Foxes with Green color: " + greenFoxList);

    //Write a Stream Expression to find the foxes with green color, and age less then 5 years!
    List<Fox> greenFoxWithLessAgeThanFive = foxes.stream()
        .filter(fox -> fox.getColor().equals("green") && fox.getAge() < 5)
        .collect(Collectors.toList());

    System.out.println("Foxes with green color and aged less than 5: "+greenFoxWithLessAgeThanFive);

    //Write a Stream Expression to find the frequency of foxes by color!
    Map<String, Long> frequencyOfFoxes = foxes.stream()
        .collect(Collectors.groupingBy(a->a.getColor(), Collectors.counting()));

    System.out.println("Frequency of foxes by color: \n"+frequencyOfFoxes);

  }
}
