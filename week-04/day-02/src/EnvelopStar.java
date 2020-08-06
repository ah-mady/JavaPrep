import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class EnvelopStar {
  public static void mainDraw(Graphics graphics) {
    drawEnvelop(15, graphics);
  }

  private static void drawEnvelop(int steps, Graphics graphics) {
    graphics.setColor(new Color(95,216,103));
    int patternWidth = WIDTH / 2;
    int patternHeight = HEIGHT / 2;
    for (int i = 1; i < steps; i++) {
      int distance = i * patternWidth / steps;
      graphics.drawLine(patternWidth, 0, patternWidth, HEIGHT);
      graphics.drawLine(patternWidth, distance, patternWidth + distance, patternHeight);
      graphics.drawLine(patternWidth, distance, patternWidth - distance, patternHeight);
      graphics.drawLine(patternWidth, HEIGHT - distance, patternWidth + distance, patternHeight);
      graphics.drawLine(patternWidth, HEIGHT - distance, patternWidth - distance, patternHeight);
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
