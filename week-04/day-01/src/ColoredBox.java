import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColoredBox {
  public static void mainDraw(Graphics graphics) {
    // Draw a box that has different colored lines on each edge.

    int size = 90;

    graphics.setColor(Color.BLACK);
    graphics.drawLine(WIDTH/2 - size, HEIGHT/2-size, WIDTH/2-size, HEIGHT/2+size);

    graphics.setColor(Color.BLUE);
    graphics.drawLine(WIDTH/2 - size, HEIGHT/2-size, WIDTH/2+size, HEIGHT/2-size);

    graphics.setColor(Color.RED);
    graphics.drawLine(WIDTH/2 + size, HEIGHT/2-size, WIDTH/2+size, HEIGHT/2+size);

    graphics.setColor(Color.MAGENTA);
    graphics.drawLine(WIDTH/2 - size, HEIGHT/2+size, WIDTH/2+size, HEIGHT/2+size);
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
