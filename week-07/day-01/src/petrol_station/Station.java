package petrol_station;

public class Station {
  static int gasAmount = 2000;

  public static void refill(Car car) {
    gasAmount -= car.capacity;
    car.gasAmount += car.capacity;
  }
}
