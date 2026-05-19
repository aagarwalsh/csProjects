package cs3500.animator.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import cs3500.animator.provider.model.IAnimatorModel;
import cs3500.animator.provider.model.IViewModel;
import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.IShapeAnimation;

public class ViewModel implements IViewModel {
  IAnimatorModel model;

  public ViewModel(IAnimatorModel model) {
    this.model = model;
  }

  @Override
  public ArrayList<IShape> getShapes(int tick) {
    return model.getShapes(tick);
  }

  @Override
  public HashMap<String, IShapeAnimation> getShapeAnimations() {
    return model.getShapeAnimations();
  }

  @Override
  public String[] getShapeNames() {
    String[] answer = new String[this.getShapeAnimations().size()];
    int i = 0;
    for (String key : getShapeAnimations().keySet()) {
      answer[i] = key;
      i++;
    }
    return answer;
  }

  @Override
  public int getStartTick() {
    return model.getStartTick();
  }

  @Override
  public int getEndTick() {
    return model.getEndTick();
  }

  @Override
  public int getCanvasWidth() {
    return model.getCanvasWidth();
  }

  @Override
  public int getCanvasHeight() {
    return model.getCanvasHeight();
  }

  @Override
  public int getTopLeftCornerX() {
    return model.getTopLeftCornerX();
  }

  @Override
  public int getTopLeftCornerY() {
    return model.getTopLeftCornerY();
  }
}
