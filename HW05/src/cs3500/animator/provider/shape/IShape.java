package cs3500.animator.provider.shape;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;

/**
 * Represents a 2D Shape which has a type, a position, dimensions, and a color.
 */
public interface IShape {
  /**
   * Returns the type of the shape.
   *
   * @return the type of the shape as a ShapeType
   */
  ShapeType getShapeType();

  /**
   * Returns the name of this IShape.
   *
   * @return name of shape
   */
  String getName();

  /**
   * Returns the position of this IShape.
   *
   * @return position of shape
   */
  Pos2D getPos();

  /**
   * Returns the dimension of this IShape.
   *
   * @return dimension of shape
   */
  Dimension2D getDimension();

  /**
   * Returns the color of this IShape.
   *
   * @return color of shape
   */
  Color getColor();
}