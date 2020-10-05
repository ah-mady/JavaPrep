import java.util.stream.Collectors;

public class Example6 {
  public static void main(String[] args) {
    //Write a Stream Expression to find the uppercase characters in a string!

    String stringWithUpperCase = "Hi, I am software Developer";

    String upperCaseFromString;

    stringWithUpperCase.chars()
        .filter(Character::isUpperCase)
        .mapToObj(c -> Character.toString((char) c))
        .forEach(System.out::println);

    //.collect(Collectors.joining());

    // System.out.println(upperCaseFromString);
  }
}
