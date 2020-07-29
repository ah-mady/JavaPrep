import java.util.Scanner;

public class DrawDiamond {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
// diamond like this:
//
//
//    *
//   ***
//  *****
// *******
//  *****
//   ***
//    *
//
// The diamond should have as many lines as the number was

    System.out.println("Please enter a number for pyramid rows: ");
    Scanner scanner = new Scanner(System.in);
    int numberOfRows = scanner.nextInt();
    for (int i = 0; i < numberOfRows; i++) {
      for (int j = i; j < numberOfRows; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j < i * 2; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

  /*  for (int i = 1; i <= numberOfRows ; i++) {
      for (int j = 0; j <=  i; j++) {
        System.out.print(" ");
      }
      for (int j = numberOfRows ; j>=(i*2)-1; j--) {
        System.out.print("*");
      }
      System.out.println();
    }*/

    for (int i = numberOfRows; i >= 0; i -= 2){
      for (int j = 0; j < numberOfRows -1 - i / 2; j++){
        System.out.print(" ");
      }
      for (int j = 0; j <= i; j++){
        System.out.print("*");
      }
      System.out.print("\n");
    }

    /*for (int i = 1; i < numberOfRows+2; i += 2) {
      for (int j = 0; j < numberOfRows - i / 2; j++)
        System.out.print(" ");

      for (int j = 0; j < i; j++)
        System.out.print("*");

      System.out.print("\n");
    }

    for (int i = numberOfRows+2; i > 0; i -= 2) {
      for (int j = 0; j < numberOfRows - i / 2; j++)
        System.out.print(" ");

      for (int j = 0; j < i; j++)
        System.out.print("*");

      System.out.print("\n");
    }*/


/*    for (int i = 1; i < 10; i += 2) {
      for (int j = 0; j < 9 - i / 2; j++)
        System.out.print(" ");

      for (int j = 0; j < i; j++)
        System.out.print("*");

      System.out.print("\n");
    }

    for (int i = 7; i > 0; i -= 2) {
      for (int j = 0; j < 9 - i / 2; j++)
        System.out.print(" ");

      for (int j = 0; j < i; j++)
        System.out.print("*");

      System.out.print("\n");
    }*/
  }
}
