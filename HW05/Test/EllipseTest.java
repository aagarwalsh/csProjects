import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Ellipse;
import cs3500.animator.model.Motion;
import cs3500.animator.model.ShapeNames;

import static org.junit.Assert.assertEquals;

/**
 * Tests for ellipse.
 */
public class EllipseTest {
  ArrayList<Motion> circMotions;
  AbstractShape circ1;

  @Before
  public void initShape() {
    circMotions = new ArrayList<>();
    circMotions.add(new Motion(5, 100, 100, 50, 50,
            200, 0, 0,
            100, 50, 50, 50, 60, 200,
            0, 0));
    circMotions.add(new Motion(10, 10, 10, 50, 60, 200,
            0, 0,
            50, 50, 50, 50, 60, 0,
            200, 150));

    circ1 = new Ellipse(ShapeNames.circle, "C", circMotions);
  }

  @Test
  public void testFormatXML() {
    circMotions.remove(0);
    assertEquals("<ellipse id=" + "\"" + "C" + "\"" + " " + "cx=" + "\"" + 0
            + "\"" + " " + "cy=" + "\"" + 0 + "\"" + " " + "rx=" + "\"" + 0 +
            "\"" + " " + "ry=" + "\"" + 0 + "\"" + " " + "fill=" + "\"rgb(" + 0
            + "," + 0 + "," + 0 + ")\"" + " " + "visibility = \"visible\">" + "\n"
            +

            //changes x position
            "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"cx\" from=\"" + 10 + "\" to=\""
            + 50 + "\" fill=\"remove\" />" + "\n"

            //changes y positions
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000
            + "ms\" attributeName=\"cy\" from=\"" + 10 + "\" to=\""
            + 50 + "\" fill=\"remove\" />" + "\n"

            // changes width
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000
            + "ms\" attributeName=\"rx\" from=\"" + 50 + "\" to=\""
            + 50 + "\" fill=\"remove\" />" + "\n"

            // changes height
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000) +
            "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"ry\" from=\"" + 60 + "\" to=\"" +
            60 + "\" fill=\"remove\" />" + "\n"

            // changes rgb
            + "<animate attributeType=\"xml\" begin=\"" + (10 * 1000)
            + "ms\" dur=\"" + (40) * 1000 +
            "ms\" attributeName=\"fill\" from=\"" + "rgb(" + 200
            + "," + 0 + "," + 0 + ")" + "\" to=\""
            + "rgb(" + 0
            + "," + 200 + "," + 150 + ")\""
            + " fill=\"remove\" />" + "\n" + "</ellipse>" + "\n", circ1.formatXML(100));
  }

  @Test
  public void testAddMotions() {
    assertEquals(2, circMotions.size());

    circ1.addMotion(new Motion(1, 60, 20, 50, 50, 0, 0, 100,
            10, 30, 30, 100, 100, 0, 200, 0));
    assertEquals(3, circMotions.size());
  }

  @Test
  public void testMotionsLength() {
    assertEquals(2, circ1.motionsLength());
  }

  @Test
  public void testGetShape() {
    assertEquals(ShapeNames.circle, circ1.shapeName());
  }

  @Test
  public void testGetMotions() {
    assertEquals(circMotions, circ1.getMotions());
  }

  @Test
  public void testPrintMotions() {
    circMotions.remove(0);
    assertEquals(("motion ") + ("C") + (" ")
            + 10 + " " + 10 + " " + 10 + " "
            + 50 + " " + 60 + " " + 200 + " " + 0 + " " + 0 + "\t"
            + 50 + " " + 50 + " " + 50 + " "
            + 50 + " " + 60 + " " + 0 + " " + 200 + " " + 150
            + ("\n"), circ1.printMotions());
  }

  @Test
  public void testPrintShape() {
    assertEquals("Shape " + "circle" + " " + "C", circ1.printShape());
  }
}