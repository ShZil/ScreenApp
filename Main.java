import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class Main extends Canvas {
  Screen[] screens;
  int screenIndex;
  Dimension size;
  int cps;
  long[] queue = new long[256];

  public Main() {
    this.size = new Dimension(1000, 1000);
    this.screenIndex = 0;
    this.screens = new Data().getData(this.size);
  }

  public static void main(String[] args) {
    Main m = new Main();
    JFrame f = new JFrame("CPS by ShZil");
    f.getContentPane().setBackground(Color.black);
    f.add(m);
    f.setSize(new Dimension(m.size.width + 17, m.size.height + 40));
    f.setVisible(true);
    m.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseReleased(MouseEvent e) {
        int to = m.mouseListener(e.getX(), e.getY());
        if (to != -1) {
          System.out.println("int screenIndex turns to: "+to+"\n-------");
          m.screenIndex = to;
          m.repaint();
        }
     }
  });
  }

  public void paint(Graphics g) {
    screens[screenIndex].render(g);
  }

  public int mouseListener(int x, int y) {
    cps++;
    return screens[screenIndex].handleClick(x, y);
  }
}
