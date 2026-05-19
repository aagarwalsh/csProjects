package cs3500.animator.provider.model;

import java.util.Objects;

/**
 * Represents a color with RGB values.
 */
public class Color {
  private final int red;
  private final int green;
  private final int blue;

  /**
   * Constructs a Color object and sets fields to given values.
   *
   * @param red   the value for red, from 0 to 255
   * @param green the value for green, from 0 to 255
   * @param blue  the value for blue, from 0 to 255
   * @throws IllegalArgumentException if any of the parameters are invalid color values
   */
  public Color(int red, int green, int blue) throws IllegalArgumentException {
    if (notRGBValue(red) || notRGBValue(green) || notRGBValue(blue)) {
      throw new IllegalArgumentException("Color value must be between 0 and 255.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  private boolean notRGBValue(int color) {
    return color < 0 || color > 255;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Color) && ((Color) o).getRed() == this.red
            && ((Color) o).getGreen() == this.green
            && ((Color) o).getBlue() == this.blue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.red, this.green, this.blue);
  }

  @Override
  public String toString() {
    return this.red + " " + this.green + " " + this.blue;
  }

  // Getters
  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }
}
