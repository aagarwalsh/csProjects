package cs3500.animator.model;

/**
 * Represents a motion to be performed by a shape. It includes dimensions, positions, colors, and
 * the tick for each motion to occur on.
 */
public class Motion {
  protected int tickStart;
  protected int posX;
  protected int posY;
  protected int width;
  protected int height;
  protected int red;
  protected int green;
  protected int blue;

  protected int tickEnd;
  protected int posXEnd;
  protected int posYEnd;
  protected int widthEnd;
  protected int heightEnd;
  protected int redEnd;
  protected int greenEnd;
  protected int blueEnd;


  /**
   * Constructor for a motion.
   *
   * @param tickStart represents the time at which this motion should be started.
   * @param posX      represents the x position of the shape the motion is being called on.
   * @param posY      represents the y position of the shape the motion is being called on.
   * @param width     represents the width of the shape the motion is being called on.
   * @param height    represents the height of the shape the motion is being called on.
   * @param red       represents the value of red in the color of the shape the motion is being
   *                  called on.
   * @param green     represents the value of green in the color of the shape the motion is being
   *                  called on.
   * @param blue      represents the value of blue in the color of the shape the motion is being
   *                  called on.
   * @param tickEnd   represents the time at which this motion should end.
   * @param posXEnd   represents the final x position of the shape in the motion.
   * @param posYEnd   represents the final y position of the shape in the motion.
   * @param widthEnd  represents the final width of the shape in the motion.
   * @param heightEnd represents the final height of the shape in the motion.
   * @param redEnd    represents the final value of red in the color of the shape in the motion.
   * @param greenEnd  represents the final value of green in the color of the shape in the motion.
   * @param blueEnd   represents the final value of blue in the color of the shape in the motion.
   */
  public Motion(int tickStart, int posX, int posY, int width, int height, int red, int green, int
          blue, int tickEnd, int posXEnd, int posYEnd, int widthEnd, int heightEnd, int redEnd, int
                        greenEnd, int blueEnd) {
    if (red > 255 || red < 0 || blue > 255 || blue < 0 || green > 255 || green < 0
            || redEnd > 255 || redEnd < 0 || blueEnd > 255 || blueEnd < 0 || greenEnd > 255 ||
            greenEnd < 0) {
      throw new IllegalArgumentException("RGB values have to be from 0 to 255");
    }
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("Dimensions have to be positive");
    } else {
      this.tickStart = tickStart;
      this.posX = posX;
      this.posY = posY;
      this.width = width;
      this.height = height;
      this.red = red;
      this.green = green;
      this.blue = blue;
      this.tickEnd = tickEnd;
      this.posXEnd = posXEnd;
      this.posYEnd = posYEnd;
      this.widthEnd = widthEnd;
      this.heightEnd = heightEnd;
      this.redEnd = redEnd;
      this.blueEnd = blueEnd;
      this.greenEnd = greenEnd;
    }
  }


  /**
   * Generates the String representation of this motion.
   *
   * @return a String representing the data of this motion.
   */
  public String print() {
    return tickStart + " " + posX + " " + posY + " "
            + width + " " + height + " " + red + " " + green + " " + blue + "\t"
            + tickEnd + " " + posXEnd + " " + posYEnd + " "
            + widthEnd + " " + heightEnd + " " + redEnd + " " + greenEnd + " " + blueEnd;
  }

  /**
   * Checks if the given motion is invalid by checking if it has the same tick as this motion. End
   * tick should not be larger than start tick.
   *
   * @param m the motion to be checked.
   * @return a boolean representing if the motion is invalid.
   */
  public boolean invalidMotion(Motion m) {
    return (m.tickStart < this.tickEnd && m.tickStart >= this.tickStart)
            || (m.tickEnd < this.tickEnd && m.tickEnd >= this.tickStart);
  }

  /**
   * Gets the start tick of this motion.
   *
   * @return an int representing the start of the motion.
   */
  public int getTickStart() {
    return this.tickStart;
  }

  /**
   * Gets the end tick of this motion.
   *
   * @return an int representing the end of the motion.
   */
  public int getTickEnd() {
    return this.tickEnd;
  }

  /**
   * Gets the starting x-position of this motion.
   *
   * @return an int representing the x position.
   */
  public int getPosX() {
    return this.posX;
  }

  /**
   * Gets the starting y-position of this motion.
   *
   * @return an int representing the y position.
   */
  public int getPosY() {
    return this.posY;
  }

  /**
   * Gets the starting width for this motion.
   *
   * @return an int representing the width.
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets the starting height for this motion.
   *
   * @return an int representing the height.
   */
  public int getHeight() {
    return this.height;
  }


  /**
   * Gets the value for the starting red color for this motion.
   *
   * @return an int representing the red rbg value.
   */
  public int getRed() {
    return this.red;
  }


  /**
   * Gets the value for the starting green color for this motion.
   *
   * @return an int representing the green rbg value.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Gets the value for the starting blue color for this motion.
   *
   * @return an int representing the blue rbg value.
   */
  public int getBlue() {
    return this.blue;
  }


  /**
   * Gets the ending x-position of this motion.
   *
   * @return an int representing the x position.
   */
  public int getPosXEnd() {
    return this.posXEnd;
  }

  /**
   * Gets the ending y-position of this motion.
   *
   * @return an int representing the y position.
   */
  public int getPosYEnd() {
    return this.posYEnd;
  }

  /**
   * Gets the end width for this motion.
   *
   * @return an int representing the width.
   */
  public int getWidthEnd() {
    return this.widthEnd;
  }

  /**
   * Gets the end height for this motion.
   *
   * @return an int representing the height.
   */
  public int getHeightEnd() {
    return this.heightEnd;
  }

  /**
   * Gets the value for the ending red color for this motion.
   *
   * @return an int representing the red rbg value.
   */
  public int getRedEnd() {
    return this.redEnd;
  }

  /**
   * Gets the value for the ending green color for this motion.
   *
   * @return an int representing the green rbg value.
   */
  public int getGreenEnd() {
    return this.greenEnd;
  }

  /**
   * Gets the value for the ending blue color for this motion.
   *
   * @return an int representing the blue rbg value.
   */
  public int getBlueEnd() {
    return this.blueEnd;
  }

  /**
   * Sets the start tick of this motion
   *
   * @param tick the tick to be set.
   */
  public void setTickStart(int tick){
    this.tickStart = tick;
}

}
