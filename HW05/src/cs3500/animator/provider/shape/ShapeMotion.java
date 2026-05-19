package cs3500.animator.provider.shape;


import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;

/**
 * Represents the state of a shape at two points in time, including position, dimensions, and
 * color. Also contains values for the two points in time.
 */
public class ShapeMotion {
  private final int startTick;
  private final int endTick;
  private final Pos2D startPos;
  private final Pos2D endPos;
  private final Dimension2D startDim;
  private final Dimension2D endDim;
  private final Color startColor;
  private final Color endColor;

  //private final Keyframe startKeyframe;
  //private final Keyframe endKeyframe;


  /**
   * Constructor for a motion.
   * Invariant: startTick <= endTick.
   *
   * @param startTick     the time at which the animation begins
   * @param startKeyframe the keyframe of the shape when the animation begins
   * @param endTick       the time at which the animation ends
   * @param endKeyframe   the keyframe of the shape when the animation ends
   * @throws IllegalArgumentException if startTick is larger than endTick
   */
  public ShapeMotion(int startTick, Keyframe startKeyframe, int endTick, Keyframe endKeyframe)
      throws IllegalArgumentException {
    if (startTick < 1) {
      throw new IllegalStateException("Start time must be positive (larger than 0).");
    } else if (startTick > endTick) {
      throw new IllegalStateException("Start time cannot be after end time.");
    }
    //this.startKeyframe = startKeyframe;
    //this.endKeyframe = endKeyframe;
    this.startTick = startTick;
    this.endTick = endTick;
    this.startPos = startKeyframe.getPos();
    this.startDim = startKeyframe.getDim();
    this.startColor = startKeyframe.getColor();
    this.endPos = endKeyframe.getPos();
    this.endDim = endKeyframe.getDim();
    this.endColor = endKeyframe.getColor();
  }

  /**
   * Whether the motion is occurring at a given tick.
   *
   * @param tick the time to check if the motion is occurring then
   * @return whether the motion is in progress at time tick
   */
  public boolean isMoving(int tick) {
    return this.startTick <= tick && tick <= this.endTick;
  }

  /**
   * Determines this motion's position at time tick, based on start and end positions and assuming
   * a linear transition.
   *
   * @param tick the time at which to determine the shape's position
   * @return the position at time tick
   * @throws IllegalArgumentException if motion is not occurring at time tick
   */
  public Pos2D getPos(int tick) throws IllegalArgumentException {
    if (!(this.isMoving(tick))) {
      throw new IllegalArgumentException("Motion is not occurring at time " + tick);
    }

    int xPos = startPos.getX() + (endPos.getX() - startPos.getX()) * (tick - startTick)
        / Math.max(1, endTick - startTick);
    int yPos = startPos.getY() + (endPos.getY() - startPos.getY()) * (tick - startTick)
        / Math.max(1, endTick - startTick);

    return new Pos2D(xPos, yPos);
  }

  /**
   * Determines this motion's dimension at time tick, based on start and end dimensions and
   * assuming a linear transition.
   *
   * @param tick the time at which to determine the shape's dimension
   * @return the dimension at time tick
   * @throws IllegalArgumentException if motion is not occurring at time tick
   */
  public Dimension2D getDim(int tick) throws IllegalArgumentException {
    if (!(this.isMoving(tick))) {
      throw new IllegalArgumentException("Motion is not occurring at time " + tick);
    }

    int width = startDim.getWidth() + (endDim.getWidth() - startDim.getWidth())
        * (tick - startTick) / Math.max(1, endTick - startTick);
    int height = startDim.getHeight() + (endDim.getHeight() - startDim.getHeight())
        * (tick - startTick) / Math.max(1, endTick - startTick);

    return new Dimension2D(width, height);
  }

  /**
   * Determines this motion's color at time tick, based on start and end colors and assuming a
   * linear transition.
   *
   * @param tick the time at which to determine the shape's color
   * @return the color at time tick
   * @throws IllegalArgumentException if motion is not occurring at time tick
   */
  public Color getColor(int tick) throws IllegalArgumentException {
    if (!(this.isMoving(tick))) {
      throw new IllegalArgumentException("Motion is not occurring at time " + tick);
    }

    int red = startColor.getRed() + (endColor.getRed() - startColor.getRed())
        * (tick - startTick) / Math.max(1, endTick - startTick);
    int green = startColor.getGreen() + (endColor.getGreen() - startColor.getGreen())
        * (tick - startTick) / Math.max(1, endTick - startTick);
    int blue = startColor.getBlue() + (endColor.getBlue() - startColor.getBlue())
        * (tick - startTick) / Math.max(1, endTick - startTick);

    return new Color(red, green, blue);
  }

  @Override
  public String toString() {
    return String.format("%d %s %s %s %d %s %s %s", this.startTick, this.startPos.toString(),
        this.startDim.toString(), this.startColor.toString(), this.endTick, this.endPos.toString(),
        this.endDim.toString(), this.endColor.toString());
  }

  /**
   * Checks whether the end values for this ShapeMotion are equal to the start values of the given
   * ShapeMotion.
   *
   * @param m the ShapeMotion whose start values should be compared to this ShapeMotion's end
   *          values
   * @return whether this motion ends the same way the given motion begins
   */
  public boolean isPerfectTransition(ShapeMotion m) {
    int mStartTick = m.getStartTick();
    return this.endTick == mStartTick
        && this.endPos.equals(m.getPos(mStartTick))
        && this.endDim.equals(m.getDim(mStartTick))
        && this.endColor.equals(m.getColor(mStartTick));
  }

  // Getters
  public int getStartTick() {
    return this.startTick;
  }

  public int getEndTick() {
    return this.endTick;
  }

  /**
   * The start keyframe of this motion.
   *
   * @return the keyframe of this motion at its start
   */
  public Keyframe getStartKeyframe() {
    return new Keyframe(startPos, startDim, startColor);
  }

  /**
   * The end keyframe of this motion.
   *
   * @return the keyframe of this motion at its end
   */
  public Keyframe getEndKeyframe() {
    return new Keyframe(endPos, endDim, endColor);
  }
}
