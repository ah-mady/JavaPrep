import java.util.Scanner;

public class OddEven {
  public static void main(String[] args) {
// Write a program that reads a number from the standard input,
// Then prints "Odd" if the number is odd, or "Even" if it is even.
    System.out.println("Please enter a number: ");
    Scanner myObj = new Scanner(System.in);
    int givenNumber = myObj.nextInt();
    if (givenNumber % 2 == 0){
      System.out.println("Even");
    } else{
      System.out.println("Odd");
    }
  }
}
