import java.util.*;

public class Example7 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:

    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM",
            "ABU DHABI", "PARIS");

    cities.stream()
        .filter(city -> city.startsWith("A"))
        .forEach(System.out::println);
  }
}
