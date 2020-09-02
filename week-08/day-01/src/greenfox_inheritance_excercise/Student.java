package greenfox_inheritance_excercise;

public class Student extends Person{

  private String previousOrganization;
  private  int skippedDays;

  public Student() {
    super("Jane Doe", 30, Gender.FEMALE);
    this.previousOrganization = "The School of life";
    this.skippedDays = 0;
  }

  public Student(String name, int age, Gender gender, String previousOrganization) {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  @Override
  public void getGoal(){
    System.out.println("Be a junior software developer.");
  }

  @Override
  public void introduce(){
    System.out.println("Hi, I'm " + this.name + " a " + this.age + " year old " + this.gender + " from " + this.previousOrganization
        + " who skipped " + this.skippedDays + " days from the course already.");
  }

  public int skippedDay(int numberOfDays){
    return this.skippedDays += numberOfDays;
  }

}
