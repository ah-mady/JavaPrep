public class SumDigit {

  public static void main(String[] args) {
    System.out.println(sumDigit(343, 0));
  }

  private static int sumDigit(int number, int sum) {
    sum += (number % 10);
    if (number > 0) {
      return sumDigit(number / 10, sum);
    } else {
      return sum;
    }
  }
}
