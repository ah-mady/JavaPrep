import java.util.Arrays;

public class Matrix {
  public static void main(String[] args) {
    // - Create (dynamically) a two dimensional array
    //   with the following matrix. Use a loop!
    //
    //   1 0 0 0
    //   0 1 0 0
    //   0 0 1 0
    //   0 0 0 1
    //
    // - Print this two dimensional array to the output

    int[][] twoDimensionalArray = {
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}
    };

    for (int rows = 0; rows < 4; rows++) {
      for (int columns = 0; columns < 4; columns++) {
        System.out.print(twoDimensionalArray[rows][columns] + " ");
      }
      System.out.println();
    }
  }
}
