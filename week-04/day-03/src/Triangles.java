import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void mainDraw(Graphics graphics) {
    //int edge = 20;

    /*graphics.drawLine(WIDTH/2, edge, edge,HEIGHT-edge); //left
    graphics.drawLine(edge, HEIGHT-edge, WIDTH - edge,HEIGHT-edge); // bottom
    graphics.drawLine(WIDTH-edge,HEIGHT-edge, WIDTH/2,edge); // right*/

    double height = Math.sqrt(3) /2;
    int pieces = 57;
    int edge = WIDTH / pieces;
    int marginTop = (int) ((HEIGHT - (height * edge * pieces)) / 2);
    int marginLeft = (WIDTH - edge * pieces) / 2;
    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, WIDTH, HEIGHT);
    graphics.setColor(Color.BLACK);
    for (int i = 1; i <= pieces; i++) {
      double yPos = HEIGHT - (height * edge * i);
      drawTriangle(marginLeft, (int) yPos - marginTop, edge * i, graphics, i == pieces, true, i == pieces);
      double pushRight = edge * (pieces - i);
      drawTriangle((int) pushRight + marginLeft, (int) yPos - marginTop, edge * i, graphics, i != pieces, false, false);
      yPos = HEIGHT - (height * edge * pieces);
      drawTriangle((int) (pushRight / 2) + marginLeft, (int) yPos - marginTop, edge * i, graphics, false, false, i != pieces);
    }

  }

  public static void drawTriangle(int xPos, int yPos, int edge, Graphics graphics, boolean left, boolean right, boolean bottom) {
    double height = Math.sqrt(3) / 2;
    if (left) {
      graphics.drawLine(xPos, (int) yPos + (int) (height * edge), xPos + edge / 2, yPos);
    }
    if (right) {
      graphics.drawLine(xPos + edge / 2, yPos, xPos + edge, yPos + (int) (height * edge));
    }
    if (bottom) {
      graphics.drawLine(xPos, yPos + (int) (height * edge), xPos + edge, yPos + (int) (height * edge));
    }
  }

  // region Don't touch the code below
  static int WIDTH = 540;
  static int HEIGHT = 540;

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
  //endregion
}