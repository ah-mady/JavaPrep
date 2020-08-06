import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class ConnectTheDots {
  public static void mainDraw(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    int[][] boxArray = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};
    int[][] dotArray = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

    connectTheDots(boxArray, graphics);
    graphics.setColor(Color.RED);
    connectTheDots(dotArray, graphics);

  }

  private static void connectTheDots(int[][] coordinates, Graphics graphics) {
    int xHolder = 0;
    int yHolder = 0;
    int secondHolderX = 0;
    int secondHolderY = 0;

    for (int i = 0; i < coordinates.length; i++) {
      if (i != 0) {
        secondHolderX = coordinates[i][0];
        secondHolderY = coordinates[i][1];
        graphics.drawLine(xHolder, yHolder, secondHolderX, secondHolderY);
      }
      xHolder = coordinates[i][0];
      yHolder = coordinates[i][1];

      if (i == coordinates.length - 1) {
        graphics.drawLine(xHolder, yHolder, coordinates[0][0], coordinates[0][1]);
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
