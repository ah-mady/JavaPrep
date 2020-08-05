import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.*;
import javax.swing.*;

public class FunctionToCenter {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Fill the canvas with lines from the edges, every 20 px, to the center.

    //drawLines(0,0,graphics);

    for (int i = 0; i <= WIDTH ; i+=20) {
      for (int j = 0; j <= HEIGHT; j+=20) {
        if (i == 0 || j == 0 || i == WIDTH || j == HEIGHT){
          drawLinesToCenter(i,j, graphics);
        }
      }
    }
  }

  private static void drawLinesToCenter(int i, int j, Graphics graphics) {
    graphics.drawLine(i,j, WIDTH/2,HEIGHT/2 );
  }

  private static void drawLines(int startingX, int startingY, Graphics graphics) {
    int edgeStartingX = startingX;
    int edgeStartingY = startingY;
    for (int i = 0; i < (WIDTH*4)/20; i++) {
      if (i < WIDTH/20) {
        graphics.drawLine(edgeStartingX,edgeStartingY, WIDTH/2,HEIGHT/2 );
        edgeStartingX += 20;
      } else if (i >= WIDTH/20 && i < WIDTH/10) {
        graphics.drawLine(edgeStartingX,edgeStartingY, WIDTH/2,HEIGHT/2 );
        edgeStartingY += 20;
      } else if (i >= WIDTH/10 && i < 48) {
        graphics.drawLine(edgeStartingX,edgeStartingY, WIDTH/2,HEIGHT/2 );
        edgeStartingX -= 20;
      } else {
        graphics.drawLine(edgeStartingX,edgeStartingY, WIDTH/2,HEIGHT/2 );
        edgeStartingY -= 20;
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
