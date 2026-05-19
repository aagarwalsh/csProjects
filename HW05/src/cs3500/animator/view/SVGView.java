package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;

/**
 * Represents one implementation of the IView interface. Scalable Vector Graphics is an XML-based
 * vector image format for two-dimensional graphics with support for interactivity and animation.
 */
public class SVGView implements IView {

  protected ArrayList<AbstractShape> shapes;
  protected Canvas canvas;
  protected int speed;

  public SVGView() {
    this.speed = 1;
  }

  /**
   * Returns a String of XML commands that form the view box for this SVG view and the model to be
   * animated.
   *
   * @return a String of XML commands.
   */
  public String xMLCommands() {
    String result = "<svg viewBox=" + "\"" + this.canvas.getX() + " "
            + this.canvas.getY() + " "
            + this.canvas.getWidth() + " " + this.canvas.getHeight()
            + "\"" + " " + "version=" + "\"1.1\"" + " "
            + "xmlns=" + "\"" + "http://www.w3.org/2000/svg" + "\"" + ">" + "\n";
    for (int i = 0; i < this.shapes.size(); i++) {
      result = result + shapeXML(this.shapes.get(i), this.speed);
    }
    result = result + "</svg>";
    return result;
  }

  /**
   * Returns the motions of the given shape in XML format.
   *
   * @return a String that represents the motions of the given shape in XML format.
   */
  private String shapeXML(AbstractShape shape, int speed) {
    return shape.formatXML(speed);
  }


  /**
   * Takes in a String and converts it to the specified svg file.
   *
   * @param toConvert String to be converted to an svg file.
   */
  public static void toFile(String toConvert, String fileName) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))) {
      bw.write(toConvert);
      System.out.println("Wrote SVG to " + fileName);

    } catch (IOException ioe) {
      throw new IllegalStateException("Could not write SVG file: " + fileName, ioe);
    }
  }


  @Override
  public void makeVisible() {
    //doesn't throw exception because controller uses it in goControl()
    // method which is called upon by Excellence.
  }

  @Override
  public void refresh() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addShapes(AbstractShape shape) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setShapes(ArrayList<AbstractShape> shapes) {
    this.shapes = shapes;
  }

  @Override
  public void setCanvas(Canvas c) {
    this.canvas = c;
  }

  @Override
  public String getKeyFrameCommand() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getShapeCommand() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setTick(int tick) {
    throw new UnsupportedOperationException();
  }

  @Override
  public VisualPanel getPanel() {
    return null;
  }

  @Override
  public void setListeners(ActionListener clicks) {
    //doesn't throw exception because controller uses it in goControl()
    // method which is called upon by Excellence.
  }

  @Override
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public boolean isVisual() {
    return false;
  }


}
