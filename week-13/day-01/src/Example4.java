import java.text.DecimalFormat;
import java.util.*;

public class Example4 {
  public static void main(String[] args) {
    //Write a Stream Expression to get the average value of the odd numbers from the following list:

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

    Double averageOfOddNumbers = numbers.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(number -> number)
        .average()
        .orElse(0.0);

    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    System.out.println(decimalFormat.format(averageOfOddNumbers));
  }
}
