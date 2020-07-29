import java.util.Arrays;

public class Reverse {
  public static void main(String[] args) {

// - Create an array variable named `numbers`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Reverse the order of the elements in `numbers`
// - Print the elements of the reversed `numbers`

    int[] numbers = {3, 4, 5, 6, 7};
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      int temp = numbers[left];
      numbers[left] = numbers[right];
      numbers[right] = temp;
      left++;
      right--;
    }
    System.out.println(Arrays.toString(numbers));
  }
}
