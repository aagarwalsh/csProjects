package cs3500.animator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;
import cs3500.animator.model.ShapeNames;

/**
 * Class to represent Panel that animation is drawn in.
 */
public class VisualPanel extends JPanel implements ActionListener {

  /*
  what information is available to the view, how to use

  how to get to one keyframe to another

  how to set a delay/speed/can the panel have this value


   */

  ArrayList<AbstractShape> shapes;
  int tick;
  Canvas canvas;
  int speed;

  /**
   * Constructs a {@code VisualPanel} object based on the superclass constructor.
   */
  public VisualPanel() {
    super();
    this.tick = 0;
  }


  protected void addShape(AbstractShape s) {
    this.shapes.add(s);
  }

  /*
  using the math for mid method and the list of motions for a shape, we can determine the correct
  shape to be displayed. instead of list of motions we need to use list of keyframes.

  might need a builder

  need to use math for mid on the end keyframe for the current motion and the start keyframe values
  along with the current tick to get the right value
   */
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);
    this.setPreferredSize(new Dimension(canvas.getWidth(), canvas.getHeight()));
    Graphics2D scene = (Graphics2D) g;
    scene.translate(canvas.getX(), canvas.getY());

    for (int i = 0; i < this.shapes.size(); i++) {
      for (int j = 0; j < this.shapes.get(i).motionsLength(); j++) {

        int red = mathForMid(this.shapes.get(i).getMotions().get(j).getRed(),
                this.shapes.get(i).getMotions().get(j).getRedEnd(),
                this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                this.shapes.get(i).getMotions().get(j).getTickEnd());

        int green = mathForMid(this.shapes.get(i).getMotions().get(j).getGreen(),
                this.shapes.get(i).getMotions().get(j).getGreenEnd(),
                this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                this.shapes.get(i).getMotions().get(j).getTickEnd());

        int blue = mathForMid(this.shapes.get(i).getMotions().get(j).getBlue(),
                this.shapes.get(i).getMotions().get(j).getBlueEnd(),
                this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                this.shapes.get(i).getMotions().get(j).getTickEnd());

        scene.setColor(new Color(red, green, blue));


        if (this.shapes.get(i).shapeName().equals(ShapeNames.rect) ||
                this.shapes.get(i).shapeName().equals(ShapeNames.square)) {

          int x = (mathForMid(
                  this.shapes.get(i).getMotions().get(j).getPosX(),
                  this.shapes.get(i).getMotions().get(j).getPosXEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd()));

          int y = mathForMid(this.shapes.get(i).getMotions().get(j).getPosY(),
                  this.shapes.get(i).getMotions().get(j).getPosYEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());
          int w = mathForMid(this.shapes.get(i).getMotions().get(j).getWidth(),
                  this.shapes.get(i).getMotions().get(j).getWidthEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          int h = mathForMid(this.shapes.get(i).getMotions().get(j).getHeight(),
                  this.shapes.get(i).getMotions().get(j).getHeightEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          scene.fillRect(x, y, w, h);
        }

        if (this.shapes.get(i).shapeName().equals(ShapeNames.circle) ||
                this.shapes.get(i).shapeName().equals(ShapeNames.ellipse)) {

          int x = mathForMid(this.shapes.get(i).getMotions().get(j).getPosX(),
                  this.shapes.get(i).getMotions().get(j).getPosXEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          int y = mathForMid(this.shapes.get(i).getMotions().get(j).getPosY(),
                  this.shapes.get(i).getMotions().get(j).getPosYEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          int width = mathForMid(this.shapes.get(i).getMotions().get(j).getWidth(),
                  this.shapes.get(i).getMotions().get(j).getWidthEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          int height = mathForMid(this.shapes.get(i).getMotions().get(j).getHeight(),
                  this.shapes.get(i).getMotions().get(j).getHeightEnd(),
                  this.tick, this.shapes.get(i).getMotions().get(j).getTickStart(),
                  this.shapes.get(i).getMotions().get(j).getTickEnd());

          scene.fillOval(x, y, width, height);

        }
      }
    }


  }

  /**
   * Equation for "tweening" that returns the state of the given value based on the given parameters
   * for that value and the time.
   *
   * @param initial   the initial value of a field of this shape
   * @param end       the end value of a field of this shape
   * @param current   the current tick
   * @param startTime the start tick
   * @param endTime   the end tick
   */
  private int mathForMid(double initial, double end, int current, int startTime, int endTime) {
    int v = 0;
    if (current >= startTime && current < endTime) {
      v = (int) (initial * (endTime - current) / ((double) (endTime - startTime)) +
              end * ((current - startTime) / ((double) (endTime - startTime))));
    }
    return v;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    tick++;
    this.repaint();
  }

}
