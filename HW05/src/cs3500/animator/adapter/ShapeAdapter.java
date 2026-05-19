
package cs3500.animator.adapter;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.ShapeType;

public class ShapeAdapter implements IShape {
  AbstractShape shape;

  ShapeAdapter(AbstractShape s) {
    this.shape = s;
  }

  @Override
  public ShapeType getShapeType() {
    ShapeType result = null;
    switch (shape.shapeName()) {
      case rect:
        result = ShapeType.RECTANGLE;
        break;

      case circle:
        result = ShapeType.ELLIPSE;
        break;

      case square:
        result = ShapeType.RECTANGLE;
        break;
      case ellipse:
        result = ShapeType.ELLIPSE;
        break;
      default:
        break;
    }
    return result;
  }

  @Override
  public String getName() {
    return shape.getLabel();
  }

  @Override
  public Pos2D getPos() {
    return null;
  }

  @Override
  public Dimension2D getDimension() {
    return null;
  }

  @Override
  public Color getColor() {
    return null;
  }
}