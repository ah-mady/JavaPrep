import java.nio.file.LinkPermission;
import java.util.Arrays;

public class SubInt {
  public static void main(String[] args) {
    //  Create a function that takes a number and an array of integers as a parameter
    //  Returns the indices of the integers in the array of which the first number is a part of
    //  Or returns an empty array if the number is not part of any of the integers in the array

    //  Example:
    System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
    //  should print: `[0, 1, 4]`
    System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
    //  should print: '[]'
  }

  private static String subInt(int number, int[] intArray) {

    int newIndex = 0;
    int[] newArray = new int[intArray.length];
    for (int i = 0; i < intArray.length; i++) {
      String stringNumberToLook = Integer.toString(number);
      String stringNumberFromArray = Integer.toString(intArray[i]);
      if (stringNumberFromArray.contains(stringNumberToLook)) {
        newArray[newIndex] = i;
        newIndex++;
      }
    }
    int[] rearrangedArray = Arrays.copyOfRange(newArray, 0, newIndex);
    return Arrays.toString(rearrangedArray);
  }
}
