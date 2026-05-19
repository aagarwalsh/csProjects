package cs3500.animator.model;

import java.util.ArrayList;

/**
 * Represents the interface for the animation model. The AnimationModelImpl implements this
 * interface and all of its methods in order to create a model to be used in an animation.
 */
public interface AnimationModel {

  /**
   * Gets the canvas of the model implementation.
   *
   * @return the Canvas of the model.
   */
  Canvas getCanvas();

  /**
   * Gets the list of shapes in this model implementation.
   *
   * @return the ArrayList of shapes.
   */
  ArrayList<AbstractShape> getShapes();

  /**
   * Adds the given KeyFrame to the appropriate shape.
   *
   * @param label the name of the shape.
   * @param tick  the tick for the keyframe.
   * @param x     the x position of the shape.
   * @param y     the y position of the shape.
   * @param w     the width of the shape.
   * @param h     the height of the shape.
   * @param r     the red rgb value of the shape.
   * @param g     the green rgb value of the shape.
   * @param b     the blue rgb value of the shape.
   */
  void addKeyFrame(String label, int tick, int x, int y, int w, int h, int r, int g, int b);

  /**
   * Removes the given KeyFrame of the appropriate shape.
   *
   * @param label the name of the shape.
   * @param tick  the tick for the keyframe.
   * @param x     the x position of the shape.
   * @param y     the y position of the shape.
   * @param w     the width of the shape.
   * @param h     the height of the shape.
   * @param r     the red rgb value of the shape.
   * @param g     the green rgb value of the shape.
   * @param b     the blue rgb value of the shape.
   */
  void removeKeyFrame(String label, int tick, int x, int y, int w, int h, int r, int g, int b);

  /**
   * Adds the given shape to the model.
   *
   * @param type  the type of the shape.
   * @param label the name of the shape.
   */
  void addShape(ShapeNames type, String label);

  /**
   * Removes the given shape from the model.
   *
   * @param type  the type of the shape.
   * @param label the name of the shape.
   */
  void removeShape(ShapeNames type, String label);
}