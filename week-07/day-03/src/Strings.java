public class Strings {
  //Given a string, compute recursively (no loops) a new string
  // where all the lowercase 'x' chars have been changed to 'y' chars.
  public static void main(String[] args) {
    System.out.println(changeXCharToY("abcxyzxyzxyz"));

  }

  private static String changeXCharToY(String string) {
    String finalString;
    int index = string.indexOf("x");
    String toAdd = "y" + string.substring(index +1);
    if (index == string.lastIndexOf("x")) {
      finalString = string.substring(0, index) + toAdd;
      return finalString;
    }
    return changeXCharToY(string.substring(0, index) + toAdd);
  }

  private static void changeXCharToYWithLoop(String string) {
    String temp = "";
    char[] stringToCharArray = string.toCharArray();
    for (char character : stringToCharArray) {
      if (character == 'x') {
        character = 'y';
      }
      System.out.print(character);
    }
  }
}
