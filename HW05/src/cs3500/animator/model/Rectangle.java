package cs3500.animator.model;

import java.util.ArrayList;

/**
 * Class to represent a rectangle shape.
 */

public class Rectangle extends AbstractShape {
  /**
   * Constructor for creating an instance of a rectangle.
   *
   * @param shapeName represents the name of the shape.
   * @param label     represents the label of the shape.
   * @param motions   represents the motions of the shape.
   */
  public Rectangle(ShapeNames shapeName, String label, ArrayList<Motion> motions) {
    super(shapeName, label, motions);
  }

  /**
   * Constructor for creating an instance of a rectangle.
   *
   * @param shapeNames represents the name of the shape.
   * @param label      represents the label of the shape.
   */
  public Rectangle(ShapeNames shapeNames, String label) {
    super(shapeNames, label, new ArrayList<Motion>());
  }

  /**
   * Formats the motions of this rectangle as into XML format to be extracted and used in SVGView.
   *
   * @return this rectangle's motions as a String in XML format.
   */
  public String formatXML(int speed) {
    String result = "<rect id=" + "\"" + this.label + "\"" + " " + "x=" + "\"" + 0
            + "\"" + " " + "y=" + "\"" + 0 + "\"" + " " + "width=" + "\"" + 0
            + "\"" + " " + "height=" + "\"" + 0 + "\"" + " " + "fill=" + "\"rgb(" + 0
            + "," + 0 + "," + 0 + ")\"" + " " + "visibility = \"visible\">" + "\n";

    for (int i = 0; i < this.motionsLength(); i++) {
      result = result +
              //changes x position
              "<animate attributeType=\"xml\" begin=\""
              + (this.motions.get(i).tickStart * (10 * speed))
              + "ms\" dur=\""
              + (this.motions.get(i).tickEnd - this.motions.get(i).tickStart) * (10 * speed)
              + "ms\" attributeName=\"x\" from=\"" + this.motions.get(i).posX + "\" to=\""
              + this.motions.get(i).posXEnd + "\" fill=\"remove\" />" + "\n"

              //changes y positions
              + "<animate attributeType=\"xml\" begin=\""
              + (this.motions.get(i).tickStart * (10 * speed))
              + "ms\" dur=\""
              + (this.motions.get(i).tickEnd - this.motions.get(i).tickStart) * (10 * speed)
              + "ms\" attributeName=\"y\" from=\"" + this.motions.get(i).posY + "\" to=\""
              + this.motions.get(i).posYEnd + "\" fill=\"remove\" />" + "\n"

              // changes width
              + "<animate attributeType=\"xml\" begin=\""
              + (this.motions.get(i).tickStart * (10 * speed)) +
              "ms\" dur=\""
              + (this.motions.get(i).tickEnd - this.motions.get(i).tickStart) * (10 * speed)
              + "ms\" attributeName=\"width\" from=\"" + this.motions.get(i).width + "\" to=\""
              + this.motions.get(i).widthEnd + "\" fill=\"remove\" />" + "\n"

              // changes height
              + "<animate attributeType=\"xml\" begin=\""
              + (this.motions.get(i).tickStart * (10 * speed))
              + "ms\" dur=\""
              + (this.motions.get(i).tickEnd - this.motions.get(i).tickStart) * (10 * speed)
              + "ms\" attributeName=\"height\" from=\"" + this.motions.get(i).height + "\" to=\""
              + this.motions.get(i).heightEnd + "\" fill=\"remove\" />" + "\n"

              // changes rgb
              + "<animate attributeType=\"xml\" begin=\""
              + (this.motions.get(i).tickStart * (10 * speed))
              + "ms\" dur=\""
              + (this.motions.get(i).tickEnd - this.motions.get(i).tickStart) * (10 * speed)
              + "ms\" attributeName=\"fill\" from=\"" + "rgb(" + this.motions.get(i).red
              + "," + this.motions.get(i).green + "," + this.motions.get(i).blue + ")"
              + "\" to=" + "\"rgb(" + this.motions.get(i).redEnd +
              "," + this.motions.get(i).greenEnd + "," + this.motions.get(i).blueEnd + ")\""
              + " fill=\"remove\" />" + "\n";
    }
    result = result + "</rect>" + "\n";
    return result;
  }
}
