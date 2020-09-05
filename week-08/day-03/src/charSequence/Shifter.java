package charSequence;

public class Shifter implements CharSequence{

  private String string;
  private int shiftedIndex;

  public Shifter(String string, int shiftedIndex) {
    this.string = string;
    this.shiftedIndex = shiftedIndex;
  }

  @Override
  public int length() {
    return this.string.length();
  }

  @Override
  public char charAt(int i) {
    return this.string.charAt(this.shiftedIndex+i);
  }

  @Override
  public CharSequence subSequence(int startingIndex, int endingIndex) {
    /*this.shiftedIndex = startingIndex;
    String subString = this.string.substring(this.shiftedIndex, endingIndex);*/
    return null;
  }
}
