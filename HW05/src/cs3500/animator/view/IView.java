package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;

/**
 * Interface to represent the view of the animation. The classes SVGView, TextualView, and
 * VisualView implement this interface.
 */
public interface IView {
  /**
   * Make the view visible. This is usually called after the view is constructed.
   */
  void makeVisible();

  /**
   * Signal the view to draw itself. Throws an exception when not supported.
   */
  void refresh();

  /**
   * Adds the given shape to the view implementation.
   *
   * @param shape represents the shape to be added.
   */
  void addShapes(AbstractShape shape);

  /**
   * Sets the shapes for the view implementation.
   *
   * @param shapes represents the list of shapes of the view.
   */
  void setShapes(ArrayList<AbstractShape> shapes);


  /**
   * Sets the canvas for the view implementation.
   *
   * @param c represents the canvas of the view.
   */
  void setCanvas(Canvas c);

  /**
   * Gets the command entered by user. Throws an exception when not supported.
   */
  String getKeyFrameCommand();

  /**
   * Gets the command entered by user. Throws an exception when not supported.
   */
  String getShapeCommand();


  /**
   * Sets the tick of the view based on the input. Throws an exception when not supported.
   *
   * @param tick represents the tick to be set.
   */
  void setTick(int tick);


  /**
   * Gets the panel of the view implementation. Throws an exception when not supported.
   *
   * @return a VisualPanel.
   */
  VisualPanel getPanel();

  /**
   * Sets the actionListeners of the view based on the controller passed in. Throws an exception
   * when not supported.
   *
   * @param clicks the ActionListener to be added.
   */
  void setListeners(ActionListener clicks);

  /**
   * Sets the speed of view to be used.
   *
   * @param speed represents the speed to be set.
   */
  void setSpeed(int speed);

  /**
   * Gets the speed of the view.
   *
   * @return the speed of the view.
   */
  int getSpeed();

  /**
   * checks if the view implmentation is visual.
   *
   * @return the boolean representing if its visual view.
   */
  boolean isVisual();

}
