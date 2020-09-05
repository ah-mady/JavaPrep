package charSequence;

public class Gnirts implements CharSequence{
  private String string;

  public Gnirts(String string) {
    this.string = string;
  }


  @Override
  public int length() {
    return this.string.length();
  }

  @Override
  public char charAt(int i) {
    return this.string.charAt(string.length() - i -1);
  }

  @Override
  public CharSequence subSequence(int start, int end) {
    return this.string.substring(start,end);
  }
}
