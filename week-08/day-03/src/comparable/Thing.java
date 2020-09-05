package comparable;

public class Thing implements Comparable<Thing>{
  private String name;
  private boolean completed;

  public Thing(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public int compareTo(Thing otherThing) {
    if (this.completed && !otherThing.completed){
      return Character.compare(this.name.charAt(0), otherThing.name.charAt(0));
    }

    if (this.completed && otherThing.completed){
      return Character.compare(this.name.charAt(0), otherThing.name.charAt(0));
    }
    return 1;
  }
}
