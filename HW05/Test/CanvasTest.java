import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.Canvas;

import static org.junit.Assert.assertEquals;


/**
 * tests for the Canvas.
 */
public class CanvasTest {

  Canvas canvas;

  @Before
  public void init() {
    canvas = new Canvas(50, 5, 300, 300);
  }

  @Test
  public void testGetX() {
    assertEquals(50, canvas.getX());
  }

  @Test
  public void testGetY() {
    assertEquals(5, canvas.getY());
  }

  @Test
  public void testGetWidth() {
    assertEquals(300, canvas.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(300, canvas.getHeight());
  }

  @Test
  public void testPrint() {
    assertEquals("canvas" + " " + 50 + " " + 5 + " " + 300 + " " + 300,
            canvas.printCanvas());
  }

}