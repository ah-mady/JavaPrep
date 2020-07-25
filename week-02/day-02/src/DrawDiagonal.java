import java.util.Scanner;

public class DrawDiagonal {
  public static void main(String[] args) {
    // Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was

    System.out.println("Please enter number of rows: ");
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < rows ; j++) {
        if (i == j){
          System.out.print("%");
        }else if (i == 0){
          System.out.print("%");
        }else if (j == 0){
          System.out.print("%");
        }else if(j == rows -1 ){
          System.out.print("%");
        }else if (i == rows-1){
          System.out.print("%");
        }else{

          System.out.print(" ");
        }

      }
      System.out.println();
    }
  }
}
