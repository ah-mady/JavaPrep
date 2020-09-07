package flyable;

public abstract class Vehicle {
  private int speed;
  private String brand;
  private String color;
  private String name;

  public Vehicle(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
