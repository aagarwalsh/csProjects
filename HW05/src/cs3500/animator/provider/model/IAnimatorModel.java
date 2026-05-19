package cs3500.animator.provider.model;

import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.IShapeAnimation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Model interface for easy animator. Holds data about an animation.
 */
public interface IAnimatorModel {
  /**
   * Adds a keyframe at the given tick with in between values if shape "name" exists at time tick.
   * Otherwise, adds a keyframe to the shape "name" with given values at time tick.
   *
   * @param name  name of shape animation to add keyframe to
   * @param tick  the tick of the keyframe to be added
   * @param pos   position to be stored in keyframe
   * @param dim   dimension to be stored in keyframe
   * @param color color to be stored in keyframe
   */
  void addKeyframe(String name, int tick, Pos2D pos, Dimension2D dim, Color color);

  /**
   * Edit the keyframe at the given tick. Only modify the fields that are not null.
   * If shape "name" does not exist at time tick, adds a keyframe at time tick.
   *
   * @param name  name of the animation to modify
   * @param tick  tick of keyframe to be modified
   * @param pos   new position
   * @param dim   new dimension
   * @param color new color
   */
  void editKeyframe(String name, int tick, Pos2D pos, Dimension2D dim, Color color);

  /**
   * Removes the keyframe in ShapeAnimation "name" with time tick.
   *
   * @param name name of shape animation to remove keyframe from
   * @param tick the tick of the keyframe to be removed
   */
  void removeKeyframe(String name, int tick);

  /**
   * Adds the given shape animation to the model.
   *
   * @param animation the animation to be added
   * @throws IllegalArgumentException if animation is null
   */
  void addShapeAnimation(IShapeAnimation animation) throws IllegalArgumentException;

  /**
   * Removes the animation "shape" from the model.
   *
   * @param name name of the animation to be removed
   * @throws IllegalArgumentException if no shape named name exists
   */
  void removeShapeAnimation(String name);

  /**
   * Calculates which shapes are visible at time tick and all their respective fields at time tick
   * and returns them in an array list.
   *
   * @param tick the time at which to calculate the list of shapes
   * @return a list of shapes at time tick in the animation
   */
  ArrayList<IShape> getShapes(int tick);

  /**
   * Returns a copy of a hash map of ShapeAnimations that cannot be used to mutate the original
   * list.
   *
   * @return a hash map of IShapeAnimations
   */
  HashMap<String, IShapeAnimation> getShapeAnimations();

  /**
   * Returns the tick at which this shape appears.
   *
   * @return the tick when this shape appears.
   */
  int getStartTick();

  /**
   * Returns the tick at which this shape disappears.
   *
   * @return the tick when this shape disappears.
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
