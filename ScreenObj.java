import java.awt.*;

class ScreenObj {
  Image bgImage;
  Color bgColor;
  Color outColor;
  String type;
  Point loc;
  Dimension size;
  public ScreenObj(Image a, Rectangle loc) {
    this.loc = loc.getLocation();
    this.size = new Dimension(loc.width, loc.height);
    this.bgImage = a;
    this.type = "Image";
  }
  public ScreenObj(Color outline, Color fill, Rectangle loc) {
    this.loc = loc.getLocation();
    this.size = new Dimension(loc.width, loc.height);
    this.bgColor = fill;
    this.outColor = outline;
    this.type = "Fill";
  }
  public ScreenObj(Color outline, Rectangle loc) {
    this.loc = loc.getLocation();
    this.size = new Dimension(loc.width, loc.height);
    this.outColor = outline;
    this.type = "Color";
  }
  public ScreenObj() {
    this.type = "Empty";
  }

  public void render(Graphics g) {
    switch (this.type) {
      case "Image":
        g.drawImage(this.bgImage,
                this.loc.x,
                this.loc.y,
                this.size.width,
                this.size.height,
                null);
      break;
      case "Color":
        g.setColor(this.outColor);
        g.drawRect(this.loc.x,
        this.loc.y,
        this.size.width,
        this.size.height);
      break;
      case "Fill":
        g.setColor(this.outColor);
        g.drawRect(this.loc.x,
        this.loc.y,
        this.size.width,
        this.size.height);
        g.setColor(this.bgColor);
        g.fillRect(this.loc.x,
        this.loc.y,
        this.size.width,
        this.size.height);
      break;
      case "Empty":

      break;
    }
  }

  @Override
  public String toString() {
    return "At: "+this.loc.toString()+", Size: "+this.size.toString()+", Type: "+this.type;
  }
}
