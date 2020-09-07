package flyable;

public class Bird extends Animal implements Flyable {

  public Bird(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs.";
  }

  @Override
  public void land() {
    System.out.println(getName() + " is landing.");
  }

  @Override
  public void fly() {
    System.out.println(getName() + " is flying right now.");
  }

  @Override
  public void takeOff() {
    System.out.println(getName() + " is gonna go away!");
  }
}
