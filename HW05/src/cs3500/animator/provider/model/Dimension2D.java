package cs3500.animator.provider.model;

import java.util.Objects;

/**
 * Represents the dimensions of a shape with a width and a height.
 */
public class Dimension2D {
  private final int width;
  private final int height;

  /**
   * Constructs a Dimension2D object and sets fields to given values.
   *
   * @param width  the value for width, must be > 0
   * @param height the value for height, must be > 0
   * @throws IllegalArgumentException if width or height is not > 0
   */
  public Dimension2D(int width, int height) throws IllegalArgumentException {
    if (!(height > 0 && width > 0)) {
      throw new IllegalArgumentException("Height and width must be a positive integer");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Dimension2D)
            && ((Dimension2D) o).getWidth() == this.width
            && ((Dimension2D) o).getHeight() == this.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.width, this.height);
  }

  @Override
  public String toString() {
    return this.width + " " + this.height;
  }

  // Getters
  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
