import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Fibonacci {
  // Fibonacci numbers: 1 1 2 3 5 8 13 21 34 55...
  // fib(10) --> should return with the 10. fibonacci number: 55

  private static Map<Integer, Long> fibonacciNumbers = new HashMap<Integer, Long>(){{
    put(1, 1L);
    put(2, 1L);
  }};

  public static void main(String[] args) {
    //milli seconds
    LocalDateTime start = LocalDateTime.now();
    System.out.println(fib(45));
    LocalDateTime end = LocalDateTime.now();
    System.out.println(Duration.between(start, end).toMillis());

    // nano seconds
  /*  long start = System.nanoTime();

    System.out.println(fib(48));

    long end = System.nanoTime();
    double executionTimeInMillis = (end - start) / 1000.;
    System.out.println(executionTimeInMillis);*/
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

  public static long fibWithMemoization(int n) {
    if (n < 1) {
      return 0;
    }
    long prev = fibonacciNumbers.containsKey(n - 1) ? fibonacciNumbers.get(n - 1) : fibWithMemoization(n - 1);
    long prevPrev = fibonacciNumbers.containsKey(n - 2) ? fibonacciNumbers.get(n - 2) : fibWithMemoization(n - 2);

    if (!fibonacciNumbers.containsKey(n - 1)) {
      fibonacciNumbers.put(n - 1, prev);
    }
    if (!fibonacciNumbers.containsKey(n - 2)) {
      fibonacciNumbers.put(n - 2, prevPrev);
    }

    return prev + prevPrev;
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
