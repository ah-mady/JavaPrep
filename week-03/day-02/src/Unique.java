import java.util.Arrays;

public class Unique {
  public static void main(String[] args) {
    //  Create a function that takes a list of numbers as a parameter
    //  Returns a list of numbers where every number in the list occurs only once

    //  Example
    System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
    //  should print: `[1, 11, 34, 52, 61]`

  }

  private static String unique(int[] inputArray) {
    int indexOfTemp = 1;
    Arrays.sort(inputArray);
    int[] temp = new int[inputArray.length];
    for (int number = 1; number < inputArray.length ; number++) {
      if (inputArray[number-1] != inputArray[number]){
        temp[indexOfTemp] = inputArray[number];
        indexOfTemp++;
      }
    }
    int[] rearrangedArray = Arrays.copyOfRange(temp,0, indexOfTemp);
    return Arrays.toString(rearrangedArray);
  }
}
