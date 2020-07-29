import java.text.DecimalFormat;
import java.util.Scanner;

public class ParametricAverage {
  public static void main(String[] args) {
    // Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4
    Scanner scanner = new Scanner(System.in);
    int number1;
    int number2;
    int number3;

    System.out.println("Please enter the integer: ");
    number1 = scanner.nextInt();
    System.out.println("Please enter the integer: ");
    number2 = scanner.nextInt();
    System.out.println("Please enter the integer: ");
    number3 = scanner.nextInt();

    int sum = number1 + number2 + number3;
    double average = (double) (number1 + number2 + number3) / 3;
    DecimalFormat format = new DecimalFormat("0.0");
    System.out.println("Sum: " + sum + ", Average: " + format.format(average));
  }
}
