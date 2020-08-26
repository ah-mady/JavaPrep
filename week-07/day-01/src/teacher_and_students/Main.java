package teacher_and_students;

public class Main {
  public static void main(String[] args) {
    Teacher pityu = new Teacher();
    Student ahmed = new Student();

    ahmed.question(pityu);
    pityu.teach(ahmed);
  }
}
