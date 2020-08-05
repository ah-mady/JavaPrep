import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenteredBoxFunction {
  public static void mainDraw(Graphics graphics) {
    // create a function that draws one square and takes 2 parameters:
    // the square size and the graphics
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    // avoid code duplication.

    drawSquare(200, graphics);
  }

  private static void drawSquare(int sizeOfSquare, Graphics graphics) {
    int numberOfSquares = 3;
    for (int i = 0; i < numberOfSquares; i++) {
      int redRandom = (int) (Math.random() * 255);
      int greenRandom = (int) (Math.random() * 255);
      int blueRandom = (int) (Math.random() * 255);
      Color randomColor = new Color(redRandom, greenRandom, blueRandom);
      graphics.setColor(randomColor);
      graphics.fillRect((WIDTH / 2) - (sizeOfSquare / 2), (HEIGHT / 2) - (sizeOfSquare / 2), sizeOfSquare, sizeOfSquare);
      sizeOfSquare -= sizeOfSquare / numberOfSquares;
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
