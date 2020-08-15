package counter;

public class Counter {

  static int defaultCounterValue;
  private int counter;

  public Counter() {
    this(0);
  }

  public Counter(int counter) {
    this.counter = counter;
    defaultCounterValue = counter;
  }

  public void add() {
    this.counter++;
  }

  public void add(int counter) {
    this.counter += counter;
  }

  public int get() {
    return counter;
  }

  public void reset() {
    counter = defaultCounterValue;
  }
}
