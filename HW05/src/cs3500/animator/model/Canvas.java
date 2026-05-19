package cs3500.animator.model;

/**
 * Class to represents the canvas for the model. x represents the x coordinate of the top left
 * corner, y represents the y coordinate of the top left corner, width is the canvas width, and
 * height is the canvas height.
 */
public class Canvas {
  protected int x;
  protected int y;
  protected int width;
  protected int height;

  /**
   * Makes a canvas with the specified coordinates for the top left corner (x,y) and width and
   * height.
   *
   * @param x      x coord of top left corner
   * @param y      y coord of top left corner
   * @param width  width of canvas
   * @param height height of canvas
   */
  public Canvas(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }


  /**
   * Gets the x coord of top left corner of this canvas.
   *
   * @return an int representing the x coord
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y coord of top left corner of this canvas.
   *
   * @return an int representing the y coord
   */
  public int getY() {
    return y;
  }

  /**
   * Gets the width this canvas.
   *
   * @return an int representing the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height this canvas.
   *
   * @return an int representing the height
   */
  public int getHeight() {
    return height;
  }


  /**
   * Gets the string representation of this canvas.
   *
   * @return a string holding the information of this canvas.
   */
  public String printCanvas() {
    return "canvas" + " " + this.x + " " + this.y + " " + this.width + " " + this.height;
  }

}
