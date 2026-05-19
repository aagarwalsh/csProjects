package cs3500.turtle.model;

/**
 * This class represents a 2D position
 */
public final class Position2D {
  private static final double EPSILON = 0.01;

  private final double x;
  private final double y;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  /**
   * Initialize this object to the specified position
   */
  public Position2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Copy constructor
   */
  public Position2D(Position2D v) {
    this(v.x, v.y);
  }

  @Override
  public String toString() {
    return String.format("(%f, %f)", this.x, this.y);
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position2D)) {
      return false;
    }

    Position2D that = (Position2D) a;

    return ((Math.abs(this.x - that.x) < EPSILON) && (Math.abs(this.y - that.y) < EPSILON));
  }

  @Override
  public int hashCode() {
    // Equality is tolerance-based, so a constant hash keeps the contract correct.
    return 0;
  }
}
