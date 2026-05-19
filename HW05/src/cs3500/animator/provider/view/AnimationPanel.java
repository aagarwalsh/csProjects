package cs3500.animator.provider.view;

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import cs3500.animator.provider.shape.ShapeType;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShape;

/**
 * Panel class for displaying animations with Java swing.
 */
public class AnimationPanel extends JPanel {
  private ArrayList<IShape> shapeListToDraw;
  private boolean showNames;

  /**
   * Constructor for AnimationPanel.
   */
  AnimationPanel() {
    super();
    this.shapeListToDraw = new ArrayList<>();
    this.showNames = false;
  }

  /**
   * Draws all shapes in given list to panel.
   *
   * @param shapes shapes to draw
   */
  void draw(ArrayList<IShape> shapes) {
    this.shapeListToDraw = shapes;
    this.repaint();
  }

  /**
   * Draws all shapes in given list to panel. Also draws names if
   *
   * @param shapes    shapes to draw
   * @param showNames whether to show names of the shapes
   */
  void draw(ArrayList<IShape> shapes, boolean showNames) {
    this.shapeListToDraw = shapes;
    this.showNames = showNames;
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shapeListToDraw == null) {
      System.out.println("shapeListToDraw is null");
    }
    for (IShape iShape : shapeListToDraw) {
      drawShape(iShape, g);
    }
  }


  private void drawShape(IShape shape, Graphics g) {
    cs3500.animator.provider.model.Color color = shape.getColor();
    Pos2D pos = shape.getPos();
    Dimension2D dim = shape.getDimension();
    g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
    if (shape.getShapeType() == ShapeType.RECTANGLE) {
      g.fillRect(pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight());
    } else if (shape.getShapeType() == ShapeType.ELLIPSE) {
      g.fillOval(pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight());
    }
    if (this.showNames) {
      Color c = g.getColor();
      g.setColor(new Color((c.getRed() + 128) % 256, (c.getGreen() + 128) % 256,
          (c.getBlue() + 128) % 256));
      g.drawString(shape.getName(), pos.getX() + 10, pos.getY() + 10);
    }
  }
}