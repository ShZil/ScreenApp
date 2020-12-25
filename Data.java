import java.awt.*;
import java.util.*;

class Data {
  public Data() {}
    // {Btn} Constructor: (Rectangle loc, int indexTo, ScreenObj ins, (?)Color outline, (?)Color fill);
    // {ScreenObj} Constructor: (Image a / Color outline, Color fill, Rectangle loc);
    // {Screen} Constructor: (Btn[] buttons, Color bg, ScreenObj[] insides, Dimension size);
  public Screen[] getData(Dimension size) {
    final int w = size.width;
    final int h = size.height;
    Rainbow color = new Rainbow();
    return new Screen[]{
      new Screen(
        new Btn[]{new Btn(
          new Rectangle(w/3,
          h-70,
          w/3,
          50),
          1,
          new ScreenObj(),
          color.black,
          color.grey
          )},
        color.dark_grey,
        new ScreenObj[]{new ScreenObj(
          color.black,
          color.blue,
          new Rectangle(50,
          50,
          w-100,
          h-150)
          )},
        size
      )
    };
  }
}

class Rainbow {
  public final Color light_grey = new Color(0.9f, 0.9f, 0.9f);
  public final Color grey = new Color(0.5f, 0.5f, 0.5f);
  public final Color dark_grey = new Color(0.2f, 0.2f, 0.2f);
  public final Color black = new Color(0f, 0f, 0f);
  public final Color white = new Color(1f, 1f, 1f);
  public final Color brown = new Color(139,69,19);
  public final Color red = Color.red;
  public final Color orange = Color.orange;
  public final Color yellow = Color.yellow;
  public final Color green = Color.green;
  public final Color lightblue = Color.cyan;
  public final Color blue = Color.blue;
  public final Color pink = new Color(255, 0, 255);
  public final Color purple = new Color(139,0,139);
}
