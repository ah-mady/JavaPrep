import java.util.Scanner;

public class AverageOfInput {
  public static void main(String[] args) {
    // Write a program that asks for 5 integers in a row,
// then it should print the sum and the average of these numbers like:
//
// Sum: 22, Average: 4.4
    System.out.println("Please enter integer 1: ");
    Scanner myObj = new Scanner(System.in);
    int integer1 = myObj.nextInt();
    System.out.println("Please enter integer 2: ");
    int integer2 = myObj.nextInt();
    System.out.println("Please enter integer 3: ");
    int integer3 = myObj.nextInt();
    System.out.println("Please enter integer 4: ");
    int integer4 = myObj.nextInt();
    System.out.println("Please enter integer 5: ");
    int integer5 = myObj.nextInt();
    int sumOfAllIntegers = integer1 + integer2 + integer3 + integer4 + integer5;
    float averageOfAllIntegers = (sumOfAllIntegers)/5;
    System.out.println("Sum: " + sumOfAllIntegers + ", Average: " + averageOfAllIntegers);
  }
}
