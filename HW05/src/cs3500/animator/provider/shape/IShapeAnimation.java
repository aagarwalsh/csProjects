package cs3500.animator.provider.shape;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.ShapeMotion;

import java.util.ArrayList;

/**
 * Interface for Shape Animations.
 */
public interface IShapeAnimation {
  /**
   * Adds a keyframe at the given tick with in between values if this IShapeAnimation exists at
   * time tick. Otherwise, adds a keyframe to this IShapeAnimation with given values at time tick.
   *
   * @param tick the tick of the keyframe to be added
   */
  void addKeyframe(int tick);

  /**
   * Adds a keyframe with the given values to this IShapeAnimation at time tick.
   *
   * @param tick  the tick of the keyframe to be added
   * @param pos   position to be stored in keyframe
   * @param dim   dimension to be stored in keyframe
   * @param color color to be stored in keyframe
   * @throws IllegalArgumentException if tick is not positive
   */
  void addKeyframe(int tick, Pos2D pos, Dimension2D dim, Color color)
      throws IllegalArgumentException;

  /**
   * Edit the keyframe at the given tick. Only modify the fields that are not null.
   * If this IShapeAnimation does not exist at time tick, adds a keyframe at time tick.
   *
   * @param tick  tick of keyframe to be modified
   * @param pos   new position
   * @param dim   new dimension
   * @param color new color
   */
  void editKeyframe(int tick, Pos2D pos, Dimension2D dim, Color color);

  /**
   * Add a ShapeMotion to this IShapeAnimation. Given ShapeMotion gets added as the last motion
   * of this ShapeMotion. Must adhere to class invariant that all motions must start where the
   * previous motion ended.
   *fc
   * @param m the motion to be added
   * @throws IllegalArgumentException if the given motion invalidates the class invariant
   */
  void addMotion(ShapeMotion m) throws IllegalArgumentException;

  /**
   * Removes this ShapeAnimation's first motion. Does nothing if the ShapeAnimation has no
   * motions.
   */
  void removeFirstMotion();

  /**
   * Removes this ShapeAnimation's last motion. Does nothing if the ShapeAnimation has no motions.
   */
  void removeLastMotion();

  /**
   * Removes the keyframe in this ShapeAnimation's with time tick.
   *
   * @param tick the tick of the keyframe to be removed
   */
  void removeKeyframe(int tick);

  /**
   * Determines if the animation's shape exists at the given time.
   * Invariant: Shape exists at all ticks in range from startTick of this animation's first motion
   * to endTick of this animation's last motion.
   *
   * @param tick time to check if shape exists
   * @return whether this animation's shape exists at time tick
   */
  boolean exists(int tick);

  /**
   * Calculates the state of this shape animation at time tick and returns an IShape holding that
   * data.
   *
   * @param tick the time at which to calculate the shape
   * @return the shape at time tick
   * @throws IllegalArgumentException if shape does not exist at time tick
   */
  IShape getShape(int tick) throws IllegalArgumentException;

  /**
   * A textual representation of the data of this animation, specifically as a String.
   *
   * @return a String with this animation's data
   */
  String toString();

  /**
   * Returns the name of this shape animation as a String.
   *
   * @return the name of the shape represented by this shape animation
   */
  String getName();

  /**
   * Returns the type of shape of this shape animation.
   *
   * @return the type of the shape represented by this shape animation
   */
  ShapeType getShapeType();

  /**
   * Copies the elements in motions to a new list and returns that list. Allows access to data
   * values without ability to mutate this shape animation.
   *
   * @return a copy of this shape animation's motions
   */
  ArrayList<ShapeMotion> getMotions();

  /**
   * Returns the tick at which this shape appears. Returns -1 if shape never appears.
   *
   * @return the tick when this shape appears (or -1 if it never appears).
   */
  int getStartTick();

  /**
   * Returns the tick at which this shape disappears. Returns -1 if shape never appears.
   *
   * @return the tick when this shape disappears (or -1 if it never appears).
   */
  int getEndTick();

  /**
   * Returns a copy of this IShapeAnimation.
   *
   * @return a copy of this IShapeAnimation
   */
  IShapeAnimation clone();
}
