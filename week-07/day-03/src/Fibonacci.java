import java.time.Duration;
import java.time.LocalDateTime;

public class Fibonacci {
  // Fibonacci numbers: 1 1 2 3 5 8 13 21 34 55...
  // fib(10) --> should return with the 10. fibonacci number: 55

  public static void main(String[] args) {
    LocalDateTime start = LocalDateTime.now();
    System.out.println(fib(45));
    LocalDateTime end = LocalDateTime.now();
    System.out.println(Duration.between(start, end).toMillis());
  }

  public static long fib(int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    return fib(n - 1) + fib(n - 2);
  }

  public static long fibWithForLoop(int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    int prevPrev = 1;
    int prev = 1;
    int actualNumber = 0;
    for (int i = 2; i < n; i++) {
      actualNumber = prev + prevPrev;
      prevPrev = prev;
      prev = actualNumber;
    }
    return actualNumber;
  }
}
