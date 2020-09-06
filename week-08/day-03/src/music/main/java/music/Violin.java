package music.main.java.music;

public class Violin extends StringedInstrument {

  private final String nameOfInstrument = "Violin";

  public Violin() {
    super(4, "Screech");
    name = nameOfInstrument;
  }

  public Violin(int numberOfStrings){
    super(numberOfStrings, "Screech");
    name = nameOfInstrument;
  }
}
