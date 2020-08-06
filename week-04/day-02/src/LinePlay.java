import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class LinePlay {
  public static void mainDraw(Graphics graphics) {

    linePlay(14, graphics);
  }

  private static void linePlay(int numberOfLines, Graphics graphics) {
    Color PURPLE = new Color(182, 78, 244);
    Color GREEN = new Color(51, 211, 65);
    graphics.setColor(PURPLE);
    for (int i = 1; i < numberOfLines; i++) {
      graphics.drawLine((WIDTH / numberOfLines) * i, 0, WIDTH, (HEIGHT / numberOfLines) * i);
    }
    graphics.setColor(GREEN);
    for (int i = 1; i < numberOfLines; i++) {
      graphics.drawLine(0, (HEIGHT / numberOfLines) * i, (WIDTH / numberOfLines) * i, HEIGHT);
    }
  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}
