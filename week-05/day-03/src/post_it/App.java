package post_it;

import java.awt.Color;

public class App {
  public static void main(String[] args) {
    PostIt idea1 = new PostIt(Color.ORANGE, "Idea 1", Color.blue);
    PostIt awesome = new PostIt(Color.PINK, "Awesome", Color.black);
    PostIt superb = new PostIt(Color.YELLOW, "Superb!", Color.green);
  }
}
