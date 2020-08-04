import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FourRectangles {
  public static void mainDraw(Graphics graphics) {
    // draw four different size and color rectangles.
    // avoid code duplication.

    int endingX = 40;
    int endingY = 40;
    int startingX = (WIDTH / 2) - endingX - endingY;
    int startingY = (HEIGHT / 2) - (endingY / 2);
    for (int i = 0; i < 4; i++) {
      int redRandom = (int) (Math.random() * 255);
      int greenRandom = (int) (Math.random() * 255);
      int blueRandom = (int) (Math.random() * 255);
      Color randomColor = new Color(redRandom, greenRandom, blueRandom);
      graphics.setColor(randomColor);
      graphics.fillRect(startingX, startingY, endingX, endingY);
      startingX += 45;
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
