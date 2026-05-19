package cs3500.animator.model;


/**
 * Represents an enumeration of String of the types of shapes that can be used in the animation. The
 * allowed shapes are rectangles, ellipses, squares, and circles.
 */
public enum ShapeNames {
  rect("rectangle"), ellipse("ellipse"), square("square"),
  circle("circle");

  public final String value;

  /**
   * constructor for this enum.
   *
   * @param value represents the string value of this enum.
   */
  ShapeNames(String value) {
    this.value = value;
  }
}
