import java.util.Scanner;

public class DrawPyramid {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
// pyramid like this:
//
//
//    *
//   ***
//  *****
// *******
//
// The pyramid should have as many lines as the number was

    System.out.println("Please enter a number for pyramid width: ");
    Scanner scanner = new Scanner(System.in);
    int numberOfRows = scanner.nextInt();
    for (int i = 0; i <numberOfRows ; i++) {
      for (int j = i; j < numberOfRows ; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < i*2; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
