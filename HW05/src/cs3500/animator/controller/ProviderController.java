package cs3500.animator.controller;

import cs3500.animator.provider.view.EditorViewListener;
import cs3500.animator.provider.view.IAnimatorView;

/**
 * Contoller to help run the provider's view.
 */
public class ProviderController {
  IAnimatorView view;
  int tick = 1;

  /**
   * Construtor for the controller.
   *
   * @param view an IAnimatorView to be displayed.
   */
  public ProviderController(IAnimatorView view) {
    this.view = view;
    view.setActionListener(new EditorViewListener());
  }

  /**
   * runs the view.
   */
  public void go() {
    view.displayAtTick(tick);
    tick++;
  }
}
