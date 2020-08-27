package petrol_station;

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    System.out.println("Petrol station gas amount before filling the car: " + Station.gasAmount);
    System.out.println("Car gas amount before filling: " + car.gasAmount);

    Station.refill(car);
    System.out.println("Petrol station gas amount after filling: " + Station.gasAmount);
    System.out.println("Car gas amount after filling: " + car.gasAmount);

    Station.refill(car);
    System.out.println("Petrol station gas amount after filling again: " + Station.gasAmount);
    System.out.println("Car gas amount after filling: " + car.gasAmount);
  }
}
