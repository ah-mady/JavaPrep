package petrol_station;

public class Car {
  protected int gasAmount;
  protected int capacity;

  public Car() {
    this(0,100);
  }

  public Car(int gasAmount, int capacity) {
    this.gasAmount = gasAmount;
    this.capacity = capacity;
  }
}
