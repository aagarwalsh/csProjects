package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;

/**
 * Represents and implementation of the IView interface. Runs an animation using the list of shapes
 * and canvas set by the controller.
 */
public class VisualView extends JFrame implements IView {
  protected VisualPanel panel;
  protected Canvas c;

  /**
   * Constructs a {@code VisualView} object.
   */
  public VisualView() {
    super();
    this.setTitle("Visual Animation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.panel = new VisualPanel();
    this.add(this.panel, BorderLayout.CENTER);

    this.pack();
  }

  @Override
  public void makeVisible() {
    this.setSize(c.getWidth(), c.getHeight());
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void addShapes(AbstractShape s) {
    this.panel.addShape(s);
  }

  @Override
  public void setShapes(ArrayList<AbstractShape> shapes) {
    this.panel.shapes = shapes;
  }

  @Override
  public void setCanvas(Canvas c) {
    this.c = c;
    this.panel.canvas = c;
  }

  @Override
  public String getKeyFrameCommand() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getShapeCommand() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setTick(int tick) {
    this.panel.tick = tick;
  }

  @Override
  public VisualPanel getPanel() {
    return this.panel;
  }

  @Override
  public void setListeners(ActionListener clicks) {
    //TODO
  }

  @Override
  public void setSpeed(int speed) {
    this.panel.speed = speed;
  }

  @Override
  public int getSpeed() {
    return this.panel.speed;
  }

  @Override
  public boolean isVisual() {
    return true;
  }

}
