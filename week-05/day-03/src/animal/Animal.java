package animal;

public class Animal {

  static int defaultHunger = 50;
  static int defaultThirst = 50;
  private int hunger;
  private int thirst;
  String animalName;

  public Animal() {
  }

  public Animal(String animalName) {
    this(animalName, defaultHunger, defaultThirst);
  }

  public Animal(String animalName, int hunger, int thirst) {
    this.animalName = animalName;
    this.setHunger(hunger);
    this.setThirst(thirst);
  }

  public int eat() {
    hunger--;
    System.out.println("After eating, hunger level decreases to : " + hunger + " for " + animalName);
    return hunger;
  }

  public int drink() {
    thirst--;
    System.out.println("After drinking, thirst level decreases to : " + thirst + " for " + animalName);
    return thirst;
  }

  public void play() {
    hunger++;
    thirst++;
  }

  private void setHunger(int hunger) {
    if (hunger > defaultHunger) {
      this.hunger = defaultHunger;
    } else {
      this.hunger = hunger;
    }
  }

  private void setThirst(int thirst) {
    if (thirst > defaultThirst) {
      this.thirst = defaultThirst;
    } else {
      this.thirst = thirst;
    }
  }

  @Override
  public String toString() {
    return animalName + " has hunger value of: " + hunger + " , and thirst value of : " + thirst;
  }
}
