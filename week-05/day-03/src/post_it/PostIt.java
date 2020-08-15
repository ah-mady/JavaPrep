package post_it;

import java.awt.Color;

public class PostIt {

  private Color backgroundColor;
  private String text;
  private Color textColor;

  public PostIt(Color backgroundColor, String text, Color textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }
}
