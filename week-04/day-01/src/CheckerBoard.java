import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class CheckerBoard {
  public static void mainDraw(Graphics graphics) {
    // Fill the canvas with a checkerboard pattern.
    int startingX;
    int startingY;
    int numberOfBoxes = 10;
    int size = WIDTH / numberOfBoxes;
    for (int rows = 0; rows < numberOfBoxes; rows++) {
      for (int columns = 0; columns < numberOfBoxes; columns++) {
        startingX = columns * (WIDTH / numberOfBoxes);
        startingY = rows * (HEIGHT / numberOfBoxes);
        if ((rows % 2) == (columns % 2)) {
          graphics.setColor(Color.BLACK);
        } else {
          graphics.setColor(Color.WHITE);
        }
        graphics.fillRect(startingX, startingY, size, size);
      }
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
