package cs3500.animator.provider.shape;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;

/**
 * Class to represent a keyframe. Created by us based on the provider's code.
 */
public class Keyframe {

  Pos2D pos;
  Dimension2D dimension2D;
  Color color;

  public Keyframe(Pos2D pos, Dimension2D d, Color color) {
    this.pos = pos;
    this.dimension2D = d;
    this.color = color;
  }


  /**
   * Gets the color of this keyframe
   *
   * @return a Color
   */
  public Color getColor() {
    return color;
  }


  /**
   * Gets the Dimension of this keyframe
   *
   * @return a Dimension2D
   */
  public Dimension2D getDim() {
    return dimension2D;
  }


  /**
   * Gets the position of this keyframe
   *
   * @return a Pos2D
   */
  public Pos2D getPos() {
    return pos;
  }
}
