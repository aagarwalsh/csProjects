package cs3500.animator.model;

import java.util.ArrayList;

/**
 * Class to represent a shape to be displayed in the animation. shapeName represents the type of
 * shape that is being made, label represents the label of the shape, motions represents the list of
 * motions for this shape, xPosn is the shape's current x coordinate on a panel, yPosn is the
 * shape's current y coordinate in a panel, width represents the shapes width, height represents the
 * shape's height, and ints red, green, and blue represent the shape's color as an rgb value.
 */
public abstract class AbstractShape {
  protected ShapeNames shapeName;
  protected String label;
  protected ArrayList<Motion> motions;


  /**
   * Constructor for creating an instance of an abstract shape.
   *
   * @param shapeName represents the name of the type of shape.
   * @param label     represents the label of the shape.
   * @param motions   represents the motions of the shape.
   */

  public AbstractShape(ShapeNames shapeName, String label, ArrayList<Motion> motions) {
    this.shapeName = shapeName;
    this.label = label;
    this.motions = motions;
  }

  public AbstractShape(ShapeNames shapeName, String label) {
    this(shapeName, label, new ArrayList<>());
  }


  /**
   * Adds the given motion to the list of motions of the shape.
   *
   * @param m represents the motion to be added.
   * @throws IllegalArgumentException if the given motion isn't valid.
   */
  public void addMotion(Motion m) {

    for (int i = 0; i < this.motions.size(); i++) {
      if (this.motions.get(i).invalidMotion(m)) {
        throw new IllegalArgumentException("Invalid motion!");
      } else {
        this.motions.add(m);
      }
    }

  }

  /**
   * Gets the length of this shape's list of motions.
   *
   * @return an int representing the number of motions for this shape.
   */
  public int motionsLength() {

    return this.motions.size();
  }

  /**
   * Generates the String output that represents the motions of the shape.
   *
   * @return a String representing the motion.
   */
  public String printMotions() {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < motions.size(); i++) {
      result.append("motion ").append(label).append(" ")
              .append(motions.get(i).print()).append("\n");
    }
    return result.toString();
  }


  /**
   * Generates the String output that represents the information of the shape.
   *
   * @return a String representing the shape.
   */
  public String printShape() {
    return "Shape " + this.shapeName.value + " " + this.label;
  }

  /**
   * Generates the XML output of the shape using its motions.
   *
   * @param speed an int to determine the duration of each animation in the SVG.
   * @return a String representing the XML output.
   */
  public abstract String formatXML(int speed);


  /**
   * Gets the name of the shape.
   *
   * @return an enum value representing the name of the shape.
   */
  public ShapeNames shapeName() {
    return this.shapeName;
  }

  /**
   * Gets the list of motions for this shape.
   *
   * @return an ArrayList of motions representing the motions of this shape.
   */
  public ArrayList<Motion> getMotions() {
    return this.motions;
  }

  /**
   * Gets the label of this shape.
   *
   * @return a string representing the label of this shape/
   */
  public String getLabel() {
    return this.label;
  }

}
