package greenfox_inheritance_excercise;

public class Sponsor extends Person {

  private String company;
  private int hiredStudents;

  public Sponsor() {
    super("Jane Doe", 30, Gender.FEMALE);
    this.company = "Google";
    this.hiredStudents = 0;
  }

  public Sponsor(String name, int age, Gender gender, String company) {
    super(name, age, gender);
    this.company = company;
    this.hiredStudents = 0;
  }

  public int hire() {
    return hiredStudents++;
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + this.name + " a " + this.age + " year old " + this.gender + " who represents " + this.company
        + " and hired " + this.hiredStudents + " students so far.");
  }

  @Override
  public void getGoal() {
    System.out.println("Hire brilliant junior software developers.");
  }
}
