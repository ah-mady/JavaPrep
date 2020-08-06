import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class StarryNight {
  public static void mainDraw(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)

    graphics.setColor(Color.BLACK);
    graphics.fillRect(0, 0, WIDTH, HEIGHT);

    for (int i = 0; i < 70; i++) {
      int randomStartingX = (int) (Math.random() * HEIGHT);
      int randomStartingY = (int) (Math.random() * WIDTH);
      int size = (int) (Math.random() * 10);
      int rgbColor = (int) (Math.random() * 255);
      Color randomColor = new Color(rgbColor, rgbColor, rgbColor);
      smallStar(randomStartingX, randomStartingY, size, randomColor, graphics);
    }
  }

  private static void smallStar(int randomStartingX, int randomStartingY, int size, Color color, Graphics graphics) {
    graphics.setColor(color);
    graphics.fillRect(randomStartingX, randomStartingY, size, size);
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
