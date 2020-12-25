import java.awt.*;

class Btn {
  Rectangle loc;
  int indexTo;
  ScreenObj ins;
  String type;
  Color outColor;
  Color fillColor;
  int thickness = 3;

  public Btn(Rectangle loc, int indexTo, ScreenObj ins, Color outline) {
    this.loc = loc;
    this.indexTo = indexTo;
    this.ins = ins;
    this.outColor = outline;
    this.type = "Out";
  }

  public Btn(Rectangle loc, int indexTo, ScreenObj ins, Color outline, Color fill) {
    this.loc = loc;
    this.indexTo = indexTo;
    this.ins = ins;
    this.outColor = outline;
    this.fillColor = fill;
    this.type = "Fill";
  }

  public Btn(Rectangle loc, int indexTo, ScreenObj ins) {
    this.loc = loc;
    this.indexTo = indexTo;
    this.ins = ins;
    this.type = "Default";
  }

  public int click(int x, int y) {
    System.out.println("X: "+x+", Y: "+y);
    return this.indexTo;
  }

  public boolean checkClick(int x, int y) {
    Point a = new Point(this.loc.x, this.loc.y);
    Point b = new Point(this.loc.x+this.loc.width, this.loc.y+this.loc.height);
    return (x > a.x & x < b.x & y > a.y & y < b.y);
  }

  public void render(Graphics g) {
    switch (this.type) {
      case "Fill":
        g.setColor(this.outColor);
        for (int i = 0; i < this.thickness; i++) {
            g.drawRect(this.loc.x - i, this.loc.y - i, this.loc.width + 2*i, this.loc.height + 2*i);
        }
        g.setColor(this.fillColor);
        g.fillRect(this.loc.x, this.loc.y, this.loc.width, this.loc.height);
      break;
      case "Out":
        g.setColor(this.outColor);
        for (int i = 0; i < this.thickness; i++) {
            g.drawRect(this.loc.x - i, this.loc.y - i, this.loc.width + 2*i, this.loc.height + 2*i);
        }
      break;
      case "Default":
        g.setColor(new Color(0f, 1f, 0f));
        g.fillRect(this.loc.x, this.loc.y, this.loc.width, this.loc.height);
      break;
    }
  }

  @Override
  public String toString() {
    return "At: "+this.loc.toString()+", To: "+this.indexTo+", Type: "+this.type;
  }
}
