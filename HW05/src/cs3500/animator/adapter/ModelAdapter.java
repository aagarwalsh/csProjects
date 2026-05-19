package cs3500.animator.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.AnimationModel;
import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.IAnimatorModel;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.IShapeAnimation;

public class ModelAdapter implements IAnimatorModel {

  AnimationModel model;

  public ModelAdapter(AnimationModel model) {
    this.model = model;
  }

  @Override
  public void addKeyframe(String name, int tick, Pos2D pos, Dimension2D dim, Color color) {
    model.addKeyFrame(name, tick, pos.getX(), pos.getY(),
            dim.getWidth(), dim.getHeight(), color.getRed(), color.getGreen(), color.getBlue());
  }

  @Override
  public void editKeyframe(String name, int tick, Pos2D pos, Dimension2D dim, Color color) {

  }

  @Override
  public void removeKeyframe(String name, int tick) {
    for (int i = 0; i < model.getShapes().size(); i++) {
      if (model.getShapes().get(i).shapeName().equals(name)) {
        for (int j = 0; j < model.getShapes().get(i).getMotions().size(); j++) {
          if (model.getShapes().get(i).getMotions().get(j).getTickEnd() == tick) {
            model.removeKeyFrame(name, tick, model.getShapes().get(i).getMotions().get(j).getPosXEnd(),
                    model.getShapes().get(i).getMotions().get(j).getPosYEnd(),
                    model.getShapes().get(i).getMotions().get(j).getWidthEnd(),
                    model.getShapes().get(i).getMotions().get(j).getHeightEnd(),
                    model.getShapes().get(i).getMotions().get(j).getRedEnd(),
                    model.getShapes().get(i).getMotions().get(j).getGreenEnd(),
                    model.getShapes().get(i).getMotions().get(j).getBlueEnd());
          }
          if (model.getShapes().get(i).getMotions().get(j).getTickStart() == tick) {
            model.removeKeyFrame(name, tick, model.getShapes().get(i).getMotions().get(j).getPosX(),
                    model.getShapes().get(i).getMotions().get(j).getPosY(),
                    model.getShapes().get(i).getMotions().get(j).getWidth(),
                    model.getShapes().get(i).getMotions().get(j).getHeight(),
                    model.getShapes().get(i).getMotions().get(j).getRed(),
                    model.getShapes().get(i).getMotions().get(j).getGreen(),
                    model.getShapes().get(i).getMotions().get(j).getBlue());
          }

        }
      }
    }
  }

  @Override
  public void addShapeAnimation(IShapeAnimation animation) throws IllegalArgumentException {

  }

  @Override
  public void removeShapeAnimation(String name) {
    for (int i = 0; i < model.getShapes().size(); i++) {
      if (model.getShapes().get(i).getLabel().equals(name)) {
        model.removeShape(model.getShapes().get(i).shapeName(), name);
      }
    }
  }

  @Override
  public ArrayList<IShape> getShapes(int tick) {
    ArrayList<IShape> result = new ArrayList<>();
    for (AbstractShape s : model.getShapes()) {
      result.add(new ShapeAdapter(s));
    }
    return result;
  }

  @Override
  public HashMap<String, IShapeAnimation> getShapeAnimations() {
    HashMap<String, IShapeAnimation> result = new HashMap<>();
    for (AbstractShape s : model.getShapes()) {
      result.put(s.getLabel(), new ShapeAnimationAdapter(s));
    }
    return result;
  }


  @Override
  public int getStartTick() {
    return 0;
  }

  @Override
  public int getEndTick() {
    return 0;
  }

  @Override
  public int getCanvasWidth() {
    return model.getCanvas().getWidth();
  }

  @Override
  public int getCanvasHeight() {
    return model.getCanvas().getHeight();
  }

  @Override
  public int getTopLeftCornerX() {
    return model.getCanvas().getX();
  }

  @Override
  public int getTopLeftCornerY() {
    return model.getCanvas().getY();
  }
}
