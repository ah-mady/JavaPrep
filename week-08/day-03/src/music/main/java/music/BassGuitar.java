package music.main.java.music;

public class BassGuitar extends StringedInstrument {

  private final String nameOfInstrument = "Bass Guitar";

  public BassGuitar() {
    super(4, "Duum-duum-duum");
    name = nameOfInstrument;
  }

  public BassGuitar(int numberOfStrings) {
    super(numberOfStrings, "Duum-duum-duum");
    name = nameOfInstrument;
  }
}
