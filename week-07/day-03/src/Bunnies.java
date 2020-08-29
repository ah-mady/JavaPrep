public class Bunnies {

  private static int ears;

  public static void main(String[] args) {
    // We have a number of bunnies and each bunny has two big floppy ears.
    // We want to compute the total number of ears across all the bunnies
    // recursively (without loops or multiplication).

    System.out.println(bunnyEarCount(7, ears));
  }

  private static int bunnyEarCount(int numberOfBunnies, int ears) {
    if (numberOfBunnies == 0) {
      return ears;
    }
    return bunnyEarCount(numberOfBunnies - 1, ears + 2);
  }
}
