public class Power {
  public static void main(String[] args) {
    System.out.println(powerN(3, 2));
  }

  private static int powerN(int number, int power) {
    if (power != 0) {
      int result = number * powerN(number, power - 1);
      return result;
    }
    return 1;
  }
}
