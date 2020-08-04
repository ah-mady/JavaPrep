import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PositionSquare {
  public static void mainDraw(Graphics graphics){
    // create a function that draws one square and takes 3 parameters:
    // the x and y coordinates of the square's top left corner and the graphics
    // and draws a 50x50 square from that point.
    // draw 3 squares with that function.
    // avoid code duplication.

    positionedSquare(25,25,graphics);

  }

  private static void positionedSquare(int startingX, int startingY, Graphics graphics) {

    for (int i = 0; i < 3; i++) {
      graphics.setColor(Color.RED);
      graphics.drawRect(startingX,startingY,50,50);
      startingX+= 70;
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
