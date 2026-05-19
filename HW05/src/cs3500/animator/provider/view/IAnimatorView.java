package cs3500.animator.provider.view;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShapeAnimation;

import java.awt.event.ActionListener;

/**
 * Interface for animation view. Allows setting of model to display, setting speed of playback,
 * and displaying the animation.
 */
public interface IAnimatorView {
  /**
   * Display the model as some form of textual description.
   */
  void display();

  /**
   * Display the state of the model at time tick.
   */
  void displayAtTick(int tick);

  /**
   * Sets the action listener for this view.
   *
   * @param clicks the action listener
   */
  void setActionListener(ActionListener clicks);

  /**
   * Reset the focus on the appropriate part of the view that has the keyboard listener attached
   * to it, so that keyboard events will still flow through.
   */
  void resetFocus();

  /**
   * Returns a String indicating which IShapeAnimation to remove and removes that String from the
   * view.
   *
   * @return which shape to remove
   */
  String shapeToRemove();

  /**
   * Returns a String indicating which IShapeAnimation is selected.
   *
   * @return which shape is selected
   */
  String shapeSelected();

  /**
   * Returns an IShapeAnimation to be added.
   *
   * @return an IShapeAnimation to add
   * @throws IllegalArgumentException if shape with same name already exists
   */
  IShapeAnimation shapeToAdd() throws IllegalArgumentException;

  /**
   * Whether this view has action listeners.
   *
   * @return whether this view has action listeners
   */
  boolean hasListeners();

  /**
   * Returns whether looping is enabled for this view.
   *
   * @return whether looping is enabled
   */
  boolean isLoopingEnabled();

  /**
   * Returns a tick that can be used to create/edit/remove a keyframe.
   *
   * @return a tick that can be used to create/edit/remove a keyframe
   */
  int keyframeTick();

  /**
   * Returns a Pos2D that can be used to create/edit a keyframe.
   *
   * @return a Pos2D that can be used to create/edit a keyframe
   */
  Pos2D keyframePos();

  /**
   * Returns a Dimension2D that can be used to create/edit a keyframe.
   *
   * @return a Dimension2D that can be used to create/edit a keyframe
   */
  Dimension2D keyframeDim();

  /**
   * Returns a Color that can be used to create/edit a keyframe.
   *
   * @return a Color that can be used to create/edit a keyframe
   */
  Color keyframeColor();
}
