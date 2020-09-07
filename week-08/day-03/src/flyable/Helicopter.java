package flyable;

public class Helicopter extends Vehicle implements Flyable {

  public Helicopter(String name) {
    super(name);
  }

  @Override
  public void land() {
    System.out.println(getName() + " is landing..");
  }

  @Override
  public void fly() {
    System.out.println(getName() + " is flying.");
  }

  @Override
  public void takeOff() {
    System.out.println(getName() + " is taking off!!");
  }
}
