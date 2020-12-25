import java.awt.*;

class Screen {
  Btn[] buttons;
  Color bg;
  ScreenObj[] insides;
  int width;
  int height;

  public Screen(Btn[] buttons, Color bg, ScreenObj[] insides, Dimension size) {
    this.buttons = buttons;
    this.bg = bg;
    this.insides = insides;
    this.width = size.width;
    this.height = size.height;
    System.out.println(this.toString());
  }

  public int handleClick(int x, int y) {
    System.out.println("Screen detected click at: ("+x+","+y+")");
    for (int i = 0; i < this.buttons.length; i++) {
      if (this.buttons[i].checkClick(x, y)) {
        return this.buttons[i].click(x, y);
      }
    }
    return -1;
  }

  public void render(Graphics g) {
    g.setColor(this.bg);
    g.fillRect(0, 0, this.width, this.height);
    for (int i = 0; i < this.buttons.length; i++) {
      this.buttons[i].render(g);
    }
    for (int i = 0; i < this.insides.length; i++) {
      this.insides[i].render(g);
    }
  }

  @Override
  public String toString() {
    String text = "Screen:\nColor: "+this.bg.toString()+"\nSize: "+new Dimension(this.width, this.height).toString();
    for (int i = 0; i < this.buttons.length; i++) {
      text+="\nButton: " + this.buttons[i].toString();
    }
    for (int i = 0; i < this.insides.length; i++) {
      text+="\nScreenObj: " + this.insides[i].toString();
    }
    return text+"\n=========";
  }
}
