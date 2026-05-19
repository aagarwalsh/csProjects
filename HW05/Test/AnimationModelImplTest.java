import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.AnimationModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * this class tests the animation model implementation.
 */
public class AnimationModelImplTest {

  AnimationModel model;
  AnimationModelImpl.Builder builder;

  @Before
  public void initModel() {
    builder = new AnimationModelImpl.Builder();
    builder.declareShape("R1", "rectangle");
    builder.declareShape("C1", "ellipse");
    builder.addMotion("R1", 1, 5, 5, 50, 50, 0, 0, 100,
            10, 20, 20, 50, 50, 0, 0, 100);

    builder.addMotion("R1", 10, 20, 20, 50, 50, 0, 0, 100,
            50, 30, 30, 100, 100, 0, 0, 100);

    builder.addMotion("C1", 1, 50, 50, 50, 50, 0, 0, 100,
            10, 60, 20, 50, 50, 0, 0, 100);

    builder.addMotion("C1", 10, 60, 20, 50, 50, 0, 0, 100,
            50, 30, 30, 100, 100, 0, 200, 0);

    builder.setBounds(0, 0, 500, 500);

    model = builder.build();

  }

  @Test
  public void testGetCanvas() {
    assertEquals(0, model.getCanvas().getX());
    assertEquals(500, model.getCanvas().getWidth());
  }

  @Test
  public void testGetShapes() {
    assertEquals(2, model.getShapes().size());
  }

}