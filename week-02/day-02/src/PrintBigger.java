import java.util.Scanner;

public class PrintBigger {
  public static void main(String[] args) {
    // Write a program that asks for two numbers and prints the bigger one
    System.out.println("Please enter first number: ");
    Scanner myObj = new Scanner(System.in);
    int firstNumber = myObj.nextInt();

    System.out.println("Please enter second number: ");
    int secondNumber = myObj.nextInt();

    if (firstNumber>secondNumber){
      System.out.println("Your first number is bigger than second: " + firstNumber);
    }else{
      System.out.println("Your second number is bigger than first: " + secondNumber);
    }
  }
}
