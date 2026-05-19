package cs3500.animator.provider.model;

import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.IShapeAnimation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * IViewModel interface, object adapter class for model.
 */
public interface IViewModel {
  /**
   * Returns the list of shapes visible at time tick with their values at that tick.
   *
   * @param tick the time at which to calculate the shapes' values
   * @return the list of shapes visible at time tick
   */
  ArrayList<IShape> getShapes(int tick);

  /**
   * Return hash map of ShapeAnimations.
   *
   * @return a hash map of ShapeAnimations
   */
  HashMap<String, IShapeAnimation> getShapeAnimations();

  /**
   * Returns the names of all shape animations.
   *
   * @return a list of shape animation names
   */
  String[] getShapeNames();

  /**
   * Returns the tick at which this shape appears.
   *
   * @return the tick when this shape appears.
   */
  int getStartTick();

  /**
   * Returns the tick at which this shape appears.
   *
   * @return the tick when this shape appears.
   */
  int getEndTick();

  /**
   * Returns the width of the canvas.
   *
   * @return the canvas' width
   */
  int getCanvasWidth();

  /**
   * Returns the height of the canvas.
   *
   * @return the canvas' height
   */
  int getCanvasHeight();

  /**
   * Returns the x position of canvas' top left corner.
   *
   * @return the x position of the top left corner
   */
  int getTopLeftCornerX();

  /**
   * Returns the y position of canvas' top left corner.
   *
   * @return the y position of the top left corner
   */
  int getTopLeftCornerY();
}
