package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;

/**
 * Represents an implementation of the IView interface. It prints out the information regarding the
 * animation in terms of its shapes, motions, and canvas.
 */
public class TextualView implements IView {

  Canvas canvas;
  ArrayList<AbstractShape> shapes;
  int speed;

  //NOTE: doesn't have a constructor because fields are initialised by
  // controller and we are relying on the default,empty constructor.

  /**
   * Prints the model of this view as a string.
   *
   * @return the model of this view as a String.
   */
  public String printView() {
    StringBuilder result = new StringBuilder();
    result.append(this.canvas.printCanvas()).append("\n");

    for (AbstractShape s : this.shapes) {
      result.append(s.printShape() + "\n");
    }

    for (AbstractShape s : this.shapes) {
      result.append(s.printMotions()).append("\n");
    }
    return result.toString();
  }

  /**
   * Writes the textual animation description to a file.
   *
   * @param contents textual animation output
   * @param fileName destination path
   */
  public static void toFile(String contents, String fileName) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
      writer.write(contents);
      System.out.println("Wrote text output to " + fileName);
    } catch (IOException e) {
      throw new IllegalStateException("Could not write text file: " + fileName, e);
    }
  }


  @Override
  public void makeVisible() {
    System.out.print(this.printView());
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
