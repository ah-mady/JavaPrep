import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoToCenter {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Draw at least 3 lines with that function using a loop.

    int numberOfLines = 3;
    graphics.setColor(Color.RED);
    Scanner scanner=new Scanner(System.in);

    int xValue = 25;
    int yValue = 10;
    for (int i = 0; i < numberOfLines ; i++) {
      drawASingleLine(xValue,yValue,graphics);
      xValue+=50;
      yValue+=40;
    }

  }

  public static void drawASingleLine(int xValue, int yValue, Graphics graphics){
    graphics.drawLine(xValue,yValue,WIDTH/2,HEIGHT/2);
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
