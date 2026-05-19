package cs3500.turtle.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import cs3500.turtle.model.Position2D;
import cs3500.turtle.tracingmodel.Line;

/**
 * This panel represents the region where the
 * lines of the turtle must be drawn.
 * <p>
 * If one has to create a container that makes
 * custom drawing, the conventional way is to
 * create a class that extends JPanel or JLabel
 */
public class TurtlePanel extends JPanel {
  private static final int PADDING = 32;
  private static final int TURTLE_SIZE = 10;

  private List<Line> lines;
  private Position2D turtlePosition;
  private double turtleHeading;

  public TurtlePanel() {
    super();
    lines = new ArrayList<>();
    this.setBackground(Color.WHITE);
    turtlePosition = new Position2D(0, 0);
    turtleHeading = 0.0;
  }

  public void setTurtlePosition(Position2D pos) {
    turtlePosition = new Position2D(pos);
  }

  public void setTurtleHeading(double h) {
    turtleHeading = h;
  }

  public void setLines(List<Line> lines) {
    this.lines = new ArrayList<>(lines);
  }

  /**
   * Override the paintComponent method of the JPanel
   * Do NOT override paint!
   *
   * @param g
   */

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    AffineTransform originalTransform = g2d.getTransform();
    double scale = applyDrawingTransform(g2d);

    g2d.setColor(new Color(35, 35, 35));
    g2d.setStroke(new BasicStroke((float) (2.0 / scale)));
    for (Line l : lines) {
      Position2D start = l.start;
      Position2D end = l.end;
      g2d.draw(new Line2D.Double(start.getX(), start.getY(), end.getX(), end.getY()));
    }

    double turtleSize = TURTLE_SIZE / scale;
    g2d.translate(Math.round(turtlePosition.getX()), Math.round(turtlePosition.getY()));
    g2d.rotate(Math.toRadians(turtleHeading));
    g2d.setColor(new Color(40, 110, 190));
    g2d.fill(new Ellipse2D.Double(-turtleSize / 2, -turtleSize / 2,
            turtleSize, turtleSize));
    g2d.setColor(new Color(220, 70, 70));
    g2d.fill(new Ellipse2D.Double(-turtleSize, -turtleSize / 2,
            turtleSize, turtleSize));

    g2d.setTransform(originalTransform);
  }

  private double applyDrawingTransform(Graphics2D g2d) {
    Bounds bounds = getDrawingBounds();
    double drawingWidth = Math.max(bounds.maxX - bounds.minX, 1);
    double drawingHeight = Math.max(bounds.maxY - bounds.minY, 1);
    double availableWidth = Math.max(getWidth() - (2.0 * PADDING), 1);
    double availableHeight = Math.max(getHeight() - (2.0 * PADDING), 1);
    double scale = Math.min(availableWidth / drawingWidth, availableHeight / drawingHeight);

    g2d.translate(
            PADDING + ((availableWidth - (drawingWidth * scale)) / 2.0),
            getHeight() - PADDING - ((availableHeight - (drawingHeight * scale)) / 2.0));
    g2d.scale(scale, -scale);
    g2d.translate(-bounds.minX, -bounds.minY);
    return scale;
  }

  private Bounds getDrawingBounds() {
    Bounds bounds = new Bounds(turtlePosition.getX(), turtlePosition.getY());
    for (Line line : lines) {
      bounds.include(line.start);
      bounds.include(line.end);
    }
    return bounds;
  }

  private static final class Bounds {
    private double minX;
    private double minY;
    private double maxX;
    private double maxY;

    Bounds(double x, double y) {
      this.minX = x;
      this.minY = y;
      this.maxX = x;
      this.maxY = y;
    }

    void include(Position2D point) {
      minX = Math.min(minX, point.getX());
      minY = Math.min(minY, point.getY());
      maxX = Math.max(maxX, point.getX());
      maxY = Math.max(maxY, point.getY());
    }
  }
}
