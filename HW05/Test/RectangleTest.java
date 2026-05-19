import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Rectangle;
import cs3500.animator.model.ShapeNames;

import static org.junit.Assert.assertEquals;

/**
 * tests for rectangle.
 */
public class RectangleTest {
  ArrayList<Motion> rectMotions;
  AbstractShape rect1;

  @Before
  public void initShape() {
    rectMotions = new ArrayList<>();
    rectMotions.add(new Motion(1, 10, 10, 50, 60, 200,
            0, 0,
            3, 50, 50, 50, 60, 200,
            0, 0));
    rectMotions.add(new Motion(10, 50, 50, 50, 60, 200,
            0, 0,
            50, 50, 50, 90, 100, 0,
            200, 150));

    rect1 = new Rectangle(ShapeNames.rect, "R", rectMotions);

  }

  @Test
  public void testFormatXML() {
    rectMotions.remove(0);
    assertEquals("<rect id=" + "\"" + "R" + "\"" + " " + "x=" + "\"" + 0
            + "\"" + " " + "y=" + "\"" + 0 + "\"" + " " + "width=" + "\"" + 0
            + "\"" + " " + "height=" + "\"" + 0 + "\"" + " " + "fill=" + "\"rgb(" + 0
            + "," + 0 + "," + 0 + ")\"" + " " + "visibility = \"visible\">" + "\n"
            +

            //changes x position
            "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000
            + "ms\" attributeName=\"x\" from=\"" + 50 + "\" to=\""
            + 50 + "\" fill=\"remove\" />" + "\n"

            //changes y positions
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000
            + "ms\" attributeName=\"y\" from=\"" + 50 + "\" to=\""
            + 50 + "\" fill=\"remove\" />" + "\n"

            // changes width
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"width\" from=\"" + 50 + "\" to=\""
            + 90 + "\" fill=\"remove\" />" + "\n"

            // changes height
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"height\" from=\"" + 60 + "\" to=\""
            + 100 + "\" fill=\"remove\" />" + "\n"

            // changes rgb
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"fill\" from=\"" + "rgb(" + 200
            + "," + 0 + "," + 0 + ")" + "\" to=\""
            + "rgb(" + 0 +
            "," + 200 + "," + 150 + ")\""
            + " fill=\"remove\" />" + "\n" + "</rect>" + "\n", rect1.formatXML(100));
  }

  @Test
  public void testAddMotions() {
    assertEquals(2, rectMotions.size());

    rect1.addMotion(new Motion(
            1, 60, 20, 50, 50, 0, 0, 100,
            10, 30, 30, 100,
            100, 0, 200, 0));
    assertEquals(3, rectMotions.size());
  }

  @Test
  public void testMotionsLength() {
    assertEquals(2, rect1.motionsLength());
  }

  @Test
  public void testGetShape() {
    assertEquals(ShapeNames.rect, rect1.shapeName());
  }

  @Test
  public void testGetMotions() {
    assertEquals(rectMotions, rect1.getMotions());
  }

  @Test
  public void testPrintMotions() {
    rectMotions.remove(0);
    assertEquals(("motion ") + ("R") + (" ")
            + 10 + " " + 50 + " " + 50 + " "
            + 50 + " " + 60 + " " + 200 + " " + 0 + " " + 0 + "\t"
            + 50 + " " + 50 + " " + 50 + " "
            + 90 + " " + 100 + " " + 0 + " " + 200 + " " + 150
            + ("\n"), rect1.printMotions());
  }

  @Test
  public void testPrintShape() {
    assertEquals("Shape " + "rectangle" + " " + "R", rect1.printShape());
  }


}