public class StringsAgain {

  // Given a string, compute recursively a new string where all the 'x' chars have been removed.

  public static void main(String[] args) {
    System.out.println(removeXCharToY("xyzxyzxyz", 'x'));
  }

  private static String removeXCharToY(String string, char target) {
    if(string.length() == 0) {
      return string;
    } else {
      if(string.charAt(0) == target) {
        return removeXCharToY(string.substring(1),target);
      } else {
        return string.charAt(0) + removeXCharToY(string.substring(1),target);
      }
    }
  }
}
