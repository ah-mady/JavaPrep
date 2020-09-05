package cloneable;

public class Student extends Person implements Cloneable {
  private String previousOrganization;
  private int skippedDays;

  public Student() {
    super("Jane Doe", 30, "female");
    this.previousOrganization = "The School of life";
    this.skippedDays = 0;
  }

  public Student(String name, int age, String gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  @Override
  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender + " from " + this.previousOrganization
        + " who skipped " + this.skippedDays + " days from the course already.");
  }

  public int skipDays(int numberOfDays) {
    return this.skippedDays += numberOfDays;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return (Student) super.clone();
  }
}
