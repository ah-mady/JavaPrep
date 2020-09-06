package music.main.java.music;

public class StringedInstrument extends Instrument {

  protected int numberOfStrings;
  private String sound;

  public StringedInstrument(int numberOfStrings, String sound) {
    this.numberOfStrings = numberOfStrings;
    this.sound = sound;
  }

  public String sound(){
    return this.sound;
  }



  @Override
  public void play() {
    System.out.println(name + ", a " + this.numberOfStrings + "-stringed instrument that goes " + sound());
  }
}
