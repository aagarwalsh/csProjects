package cs3500.animator.provider.model;

import java.util.Objects;

/**
 * Represents a 2D position with an x and a y coordinate.
 */
public class Pos2D {
  private final int x;
  private final int y;

  /**
   * Constructs a Pos2D object and sets fields to given values.
   *
   * @param x the value for x
   * @param y the value for y
   */
  public Pos2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Pos2D) && ((Pos2D) o).getX() == this.x && ((Pos2D) o).getY() == this.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public String toString() {
    return this.x + " " + this.y;
  }

  // Getters
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
