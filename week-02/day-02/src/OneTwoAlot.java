import java.util.Scanner;

public class OneTwoAlot {
  public static void main(String[] args) {
    // Write a program that reads a number form the standard input,
// If the number is zero or smaller it should print: Not enough
// If the number is one it should print: One
// If the number is two it should print: Two
// If the number is more than two it should print: A lot
    System.out.println("Please enter a number: ");
    Scanner myObj = new Scanner(System.in);
    int givenNumber = myObj.nextInt();
    if (givenNumber <= 0 ){
      System.out.println("Not Enough");
    } else if (givenNumber == 1){
      System.out.println("One");
    } else if (givenNumber == 2){
      System.out.println("Two");
    } else {
      System.out.println("A lot");
    }
  }
}
