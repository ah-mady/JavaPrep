package greenfox_inheritance_excercise;

public class Mentor extends Person {
  private Level level;

  public Mentor() {
    super("Jane Doe", 30, Gender.FEMALE);
    this.level = Level.INTERMEDIATE;
  }

  public Mentor(String name, int age, Gender gender, Level level) {
    super(name, age, gender);
    this.level = level;
  }

  @Override
  public void getGoal() {
    System.out.println("Educate brilliant junior software developers.");
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender + " " + this.level + " mentor.");
  }
}
