

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;


public class PurpleSteps {
  public static void mainDraw(Graphics graphics) {
    // Reproduce this:
    // [https://github.com/green-fox-academy/teaching-materials/blob/master/workshop/drawing/assets/r3.png]

    Color PURPLE = new Color(150, 40, 141);
    graphics.setColor(PURPLE);
    int size = 15;
    int startingPosition = size;
    for (int i = 0; i < 15; i++) {
      graphics.fillRect(startingPosition, startingPosition, size, size);
      startingPosition += size;
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
