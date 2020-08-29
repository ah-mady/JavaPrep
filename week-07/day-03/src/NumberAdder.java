public class NumberAdder {
  public static void main(String[] args) {
    System.out.println(numberAdder(3));
  }

  private static int numberAdder(int numberTill) {
    if (numberTill < 1) {
      return 0;
    }
    if (!(numberTill == 0)) {
      int addedNumber = numberTill + numberAdder(numberTill - 1);
      return addedNumber;
    }
    return 0;
  }
}
