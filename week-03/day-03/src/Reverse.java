public class Reverse {
  public static void main(String[] args) {
    String toBeReversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

    // Create a method that can reverse a String, which is passed as the parameter
    // Use it on this reversed string to check it!
    // Try to solve this using charAt() first, and optionally anything else after.

    System.out.println(reverse(toBeReversed));

  }

  private static char[] reverse(String toBeReversed) {
    char[] reversedChar = toBeReversed.toCharArray();
    int begin = 0;
    int end = reversedChar.length - 1;
    char temp;
    while (end > begin) {
      temp = reversedChar[begin];
      reversedChar[begin] = reversedChar[end];
      reversedChar[end] = temp;
      end--;
      begin++;
    }
    return reversedChar;
  }
}
