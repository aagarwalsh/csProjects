import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.Motion;

import static org.junit.Assert.assertEquals;

/**
 * tests for motion.
 */
public class MotionTest {
  Motion one;
  Motion two;

  @Before
  public void init() {
    one = new Motion(100, 10, 10, 50, 60, 200,
            0, 0,
            500, 50, 50, 50, 60, 0,
            200, 150);
    two = new Motion(5, 100, 100, 50, 50, 200,
            0, 0,
            100, 50, 50, 50, 60, 200,
            0, 0);
  }

  @Test
  public void testPrint() {
    assertEquals(100 + " " + 10 + " " + 10 + " "
            + 50 + " " + 60 + " " + 200 + " " + 0 + " " + 0 + "\t"
            + 500 + " " + 50 + " " + 50 + " "
            + 50 + " " + 60 + " " + 0 + " " + 200 + " " + 150, one.print());
  }

  @Test
  public void testInValidMotion() {
    assertEquals(true, one.invalidMotion(two));
  }

  @Test
  public void testValidMotion() {
    assertEquals(false, two.invalidMotion(one));
  }

  @Test
  public void testGetTickStart() {
    assertEquals(100, one.getTickStart());
  }

  @Test
  public void testGetTickEnd() {
    assertEquals(500, one.getTickEnd());
  }

  @Test
  public void testGetPosX() {
    assertEquals(10, one.getPosX());
  }

  @Test
  public void testGetPosY() {
    assertEquals(10, one.getPosY());
  }

  @Test
  public void testGetWidth() {
    assertEquals(50, one.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(60, one.getHeight());
  }

  @Test
  public void testGetRed() {
    assertEquals(200, one.getRed());
  }

  @Test
  public void testGetGreen() {
    assertEquals(0, one.getGreen());
  }

  @Test
  public void testGetBlue() {
    assertEquals(0, one.getBlue());

  }

  @Test
  public void testGetPosXEnd() {
    assertEquals(50, one.getPosXEnd());
  }

  @Test
  public void testGetPosYEnd() {
    assertEquals(50, one.getPosYEnd());
  }

  @Test
  public void testGetWidthEnd() {
    assertEquals(50, one.getWidthEnd());
  }

  @Test
  public void testGetHeightEnd() {
    assertEquals(60, one.getHeightEnd());
  }

  @Test
  public void testGetRedEnd() {
    assertEquals(0, one.getRedEnd());
  }

  @Test
  public void testGetGreenEnd() {
    assertEquals(200, one.getGreenEnd());
  }

  @Test
  public void testGetBlueEnd() {
    assertEquals(150, one.getBlueEnd());

  }


}