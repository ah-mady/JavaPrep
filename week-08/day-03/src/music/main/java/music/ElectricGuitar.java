package music.main.java.music;

public class ElectricGuitar extends StringedInstrument {

  private final String nameOfInstrument = "Electric Guitar";

  public ElectricGuitar() {
    super(6, "Twang");
    name = nameOfInstrument;
  }

  public ElectricGuitar(int numberOfStrings) {
    super(numberOfStrings, "Twang");
    name = nameOfInstrument;
  }
}
