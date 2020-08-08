public class PalindromeBuilder {
  public static void main(String[] args) {
    createPalindrome("123");
  }

  private static void createPalindrome(String inputForPalindrome) {
    String finalPalindrome = inputForPalindrome;
    char[] inputCharArray = inputForPalindrome.toLowerCase().toCharArray();
    char[] copyOfInputArray = new char[inputCharArray.length];
    for (int i = inputCharArray.length - 1; i >= 0; i--) {
      for (int j = 0; j < inputCharArray.length; j++) {
        copyOfInputArray[j] += inputCharArray[i];
        i--;
      }
      break;
    }
    String reversedString = new String(copyOfInputArray);
    finalPalindrome += reversedString;
    System.out.println(finalPalindrome);
  }
}
