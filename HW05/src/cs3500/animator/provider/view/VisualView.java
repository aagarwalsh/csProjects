package cs3500.animator.provider.view;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.IViewModel;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShapeAnimation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 * VisualView class, used to output an visual representation of model data with java swing.
 */
public class VisualView extends JFrame implements IAnimatorView {
  IViewModel viewModel;
  AnimationPanel panel;
  private int ticksPerSecond;

  /**
   * Constructs a VisualView instance and sets its fields with the given values.
   *
   * @param viewModel instance of object adapter class for model
   */
  public VisualView(IViewModel viewModel, int ticksPerSecond) {
    this();
    if (viewModel == null) {
      throw new IllegalArgumentException("viewModel cannot be null.");
    }
    if (ticksPerSecond < 1) {
      throw new IllegalArgumentException("Ticks per second must be positive.");
    }
    this.viewModel = viewModel;
    this.ticksPerSecond = ticksPerSecond;

    panel.setPreferredSize(new Dimension(this.viewModel.getCanvasWidth(),
        this.viewModel.getCanvasHeight()));
    JScrollPane scrollPane = new JScrollPane(panel, VERTICAL_SCROLLBAR_AS_NEEDED,
        HORIZONTAL_SCROLLBAR_AS_NEEDED);

    scrollPane.setHorizontalScrollBar(scrollPane.createHorizontalScrollBar());
    scrollPane.setVerticalScrollBar(scrollPane.createVerticalScrollBar());

    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(scrollPane, BorderLayout.CENTER);

    this.pack();
    //this.setVisible(true);
  }

  VisualView() {
    this.panel = new AnimationPanel();
  }

  @Override
  public void display() {
    // displays the frame of the current state then updates view to next state
    //throw new UnsupportedOperationException("display() not supported for VisualView.");
    // plays the animation by displaying the frame for each tick
    this.setVisible(true);

    for (int ii = 0; ii < this.viewModel.getEndTick(); ii++) {
      panel.draw(viewModel.getShapes(ii));
      try {
        // (1000 us/s)/(# of ticks/s) = # of us/tick, i.e. the delay before the next tick
        TimeUnit.MICROSECONDS.sleep(1000000 / ticksPerSecond);
      } catch (InterruptedException e) {
        System.out.println("Interrupted exception.");
      }
    }
  }

  @Override
  public void displayAtTick(int tick) {
    throw new UnsupportedOperationException("displayAtTick() not supported for VisualView.");
  }

  @Override
  public void setActionListener(ActionListener clicks) {
    throw new UnsupportedOperationException("setListeners() not supported for VisualView.");
  }

  @Override
  public void resetFocus() {
    throw new UnsupportedOperationException("resetFocus() not supported for VisualView.");
  }

  @Override
  public String shapeToRemove() {
    throw new UnsupportedOperationException("shapeToRemove() not supported for VisualView.");
  }

  @Override
  public String shapeSelected() {
    throw new UnsupportedOperationException("shapeSelected() not supported for VisualView.");
  }

  @Override
  public IShapeAnimation shapeToAdd() {
    throw new UnsupportedOperationException("shapeToAdd() not supported for VisualView.");
  }

  @Override
  public boolean hasListeners() {
    return false;
  }

  @Override
  public boolean isLoopingEnabled() {
    throw new UnsupportedOperationException("isLoopingEnabled() not supported for VisualView.");
  }

  @Override
  public int keyframeTick() {
    throw new UnsupportedOperationException("keyframeTick() not supported for VisualView.");
  }

  @Override
  public Pos2D keyframePos() {
    throw new UnsupportedOperationException("keyframePos() not supported for VisualView.");
  }

  @Override
  public Dimension2D keyframeDim() {
    throw new UnsupportedOperationException("keyframeDim() not supported for VisualView.");
  }

  @Override
  public Color keyframeColor() {
    throw new UnsupportedOperationException("keyframeColor() not supported for VisualView.");
  }
}