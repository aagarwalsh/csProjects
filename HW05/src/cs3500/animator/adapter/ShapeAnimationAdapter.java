package cs3500.animator.adapter;

import java.util.ArrayList;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Motion;
import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShape;
import cs3500.animator.provider.shape.IShapeAnimation;
import cs3500.animator.provider.shape.Keyframe;
import cs3500.animator.provider.shape.ShapeMotion;
import cs3500.animator.provider.shape.ShapeType;

public class ShapeAnimationAdapter implements IShapeAnimation {

  AbstractShape shape;

  ShapeAnimationAdapter(AbstractShape s) {
    this.shape = s;
  }


  @Override
  public void addKeyframe(int tick) {
    //???
  }

  @Override
  public void addKeyframe(int tick, Pos2D pos, Dimension2D dim, Color color) throws IllegalArgumentException {
    if (tick < 0) {
      throw new IllegalArgumentException("Tick must be positive!");
    }
    for (int j = 0; j < shape.getMotions().size() - 1; j++) {
      if (shape.getMotions().get(j).getTickStart() < tick &&
              (shape.getMotions().get(j).getTickEnd() > tick)) {

        Motion m = new Motion(tick, pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight(),
                color.getRed(), color.getGreen(), color.getBlue(),
                shape.getMotions().get(j).getTickEnd(),
                shape.getMotions().get(j).getPosXEnd(),
                shape.getMotions().get(j).getPosYEnd(),
                shape.getMotions().get(j).getWidthEnd(),
                shape.getMotions().get(j).getHeightEnd(),
                shape.getMotions().get(j).getRedEnd(),
                shape.getMotions().get(j).getGreenEnd(),
                shape.getMotions().get(j).getBlueEnd());
        shape.getMotions().add(j, m);
        shape.getMotions().get(j).setTickStart(tick);
      }

      if (shape.getMotions().get(j).getTickEnd() > tick &&
              (shape.getMotions().get(j + 1).getTickStart() < tick)) {
        Motion m = new Motion(tick, pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight(),
                color.getRed(), color.getGreen(), color.getBlue(),
                shape.getMotions().get(j + 1).getTickEnd(),
                shape.getMotions().get(j + 1).getPosXEnd(),
                shape.getMotions().get(j + 1).getPosYEnd(),
                shape.getMotions().get(j + 1).getWidthEnd(),
                shape.getMotions().get(j + 1).getHeightEnd(),
                shape.getMotions().get(j + 1).getRedEnd(),
                shape.getMotions().get(j + 1).getGreenEnd(),
                shape.getMotions().get(j + 1).getBlueEnd());
        shape.getMotions().add(j + 1, m);
      }

      if (tick < shape.getMotions().get(0).getTickStart()) {
        Motion m = new Motion(tick, pos.getX(), pos.getY(), dim.getWidth(), dim.getHeight(),
                color.getRed(), color.getGreen(), color.getBlue(),
                shape.getMotions().get(0).getTickEnd(),
                shape.getMotions().get(0).getPosXEnd(),
                shape.getMotions().get(0).getPosYEnd(),
                shape.getMotions().get(0).getWidthEnd(),
                shape.getMotions().get(0).getHeightEnd(),
                shape.getMotions().get(0).getRedEnd(),
                shape.getMotions().get(0).getGreenEnd(),
                shape.getMotions().get(0).getBlueEnd());
        shape.getMotions().add(0, m);
      }


    }
  }

  @Override
  public void editKeyframe(int tick, Pos2D pos, Dimension2D dim, Color color) {

  }

  @Override
  public void addMotion(ShapeMotion m) throws IllegalArgumentException {
    Motion mot = new Motion(m.getStartTick(), m.getStartKeyframe().getPos().getX(),
            m.getStartKeyframe().getPos().getY(),
            m.getStartKeyframe().getDim().getWidth(),
            m.getStartKeyframe().getDim().getHeight(),
            m.getStartKeyframe().getColor().getRed(),
            m.getStartKeyframe().getColor().getGreen(),
            m.getStartKeyframe().getColor().getBlue(),
            m.getEndTick(),
            m.getEndKeyframe().getPos().getX(),
            m.getEndKeyframe().getPos().getY(),
            m.getEndKeyframe().getDim().getWidth(),
            m.getEndKeyframe().getDim().getHeight(),
            m.getEndKeyframe().getColor().getRed(),
            m.getEndKeyframe().getColor().getGreen(),
            m.getEndKeyframe().getColor().getBlue());
    shape.addMotion(mot);
  }

  @Override
  public void removeFirstMotion() {
    shape.getMotions().remove(0);
  }

  @Override
  public void removeLastMotion() {
    shape.getMotions().remove(shape.getMotions().size() - 1);
  }

  @Override
  public void removeKeyframe(int tick) {
    for (int i = 0; i < shape.getMotions().size(); i++) {
      if (shape.getMotions().get(i).getTickStart() == tick &&
              i != shape.getMotions().size() - 1) {
        Motion add = new Motion(shape.getMotions().get(i).getTickStart(),
                shape.getMotions().get(i).getPosXEnd(),
                shape.getMotions().get(i).getPosYEnd(),
                shape.getMotions().get(i).getWidthEnd(),
                shape.getMotions().get(i).getHeightEnd(),
                shape.getMotions().get(i).getRedEnd(),
                shape.getMotions().get(i).getGreenEnd(),
                shape.getMotions().get(i).getBlueEnd(),
                shape.getMotions().get(i + 1).getTickStart(),
                shape.getMotions().get(i + 1).getPosX(),
                shape.getMotions().get(i + 1).getPosY(),
                shape.getMotions().get(i + 1).getWidth(),
                shape.getMotions().get(i + 1).getHeight(),
                shape.getMotions().get(i + 1).getRed(),
                shape.getMotions().get(i + 1).getGreen(),
                shape.getMotions().get(i + 1).getBlue());
        shape.getMotions().add(i + 1, add);
        shape.getMotions().remove(shape.getMotions().get(i));
      }

      if (shape.getMotions().get(i).getTickEnd() == tick &&
              i == shape.getMotions().size() - 1) {
        Motion add = new Motion(shape.getMotions().get(i - 1).getTickEnd(),
                shape.getMotions().get(i - 1).getPosXEnd(),
                shape.getMotions().get(i - 1).getPosYEnd(),
                shape.getMotions().get(i - 1).getWidthEnd(),
                shape.getMotions().get(i - 1).getHeightEnd(),
                shape.getMotions().get(i - 1).getRedEnd(),
                shape.getMotions().get(i - 1).getGreenEnd(),
                shape.getMotions().get(i - 1).getBlueEnd(),
                shape.getMotions().get(i).getTickStart(),
                shape.getMotions().get(i).getPosX(),
                shape.getMotions().get(i).getPosY(),
                shape.getMotions().get(i).getWidth(),
                shape.getMotions().get(i).getHeight(),
                shape.getMotions().get(i).getRed(),
                shape.getMotions().get(i).getGreen(),
                shape.getMotions().get(i).getBlue());
        shape.getMotions().add(i, add);
        shape.getMotions().remove(shape.getMotions().get(i + 1));
      }

      if (shape.getMotions().get(i).getTickEnd() == tick &&
              i != shape.getMotions().size() - 1) {
        Motion add = new Motion(shape.getMotions().get(i).getTickStart(),
                shape.getMotions().get(i).getPosX(),
                shape.getMotions().get(i).getPosY(),
                shape.getMotions().get(i).getWidth(),
                shape.getMotions().get(i).getHeight(),
                shape.getMotions().get(i).getRed(),
                shape.getMotions().get(i).getGreen(),
                shape.getMotions().get(i).getBlue(),
                shape.getMotions().get(i + 1).getTickStart(),
                shape.getMotions().get(i + 1).getPosX(),
                shape.getMotions().get(i + 1).getPosY(),
                shape.getMotions().get(i + 1).getWidth(),
                shape.getMotions().get(i + 1).getHeight(),
                shape.getMotions().get(i + 1).getRed(),
                shape.getMotions().get(i + 1).getGreen(),
                shape.getMotions().get(i + 1).getBlue());
        shape.getMotions().add(i, add);
        shape.getMotions().remove(shape.getMotions().get(i + 1));
      }
    }
  }


  @Override
  public boolean exists(int tick) {
    return false;
  }

  @Override
  public IShape getShape(int tick) throws IllegalArgumentException {
    return new ShapeAdapter(shape);
  }

  @Override
  public String getName() {
    return shape.getLabel();
  }


  //needs to return the shape enum but our enums are different so that is a problem
  @Override
  public ShapeType getShapeType() {
    return null;
  }

  @Override
  public ArrayList<ShapeMotion> getMotions() {
    ArrayList<ShapeMotion> motions = new ArrayList<ShapeMotion>();
    for (int i = 0; i < shape.getMotions().size(); i++) {
      motions.add(new ShapeMotion(shape.getMotions().get(i).getTickStart(),

              new Keyframe(new Pos2D(shape.getMotions().get(i).getPosX(),
                      shape.getMotions().get(i).getPosY()),
                      new Dimension2D(shape.getMotions().get(i).getWidth(), shape.getMotions().get(i).getHeight()),
                      new Color(shape.getMotions().get(i).getRed(),
                              shape.getMotions().get(i).getGreen(), shape.getMotions().get(i).getBlue())),
              shape.getMotions().get(i).getTickEnd(),
              new Keyframe(
                      new Pos2D(shape.getMotions().get(i).getPosXEnd(),
                              shape.getMotions().get(i).getPosYEnd()),
                      new Dimension2D(shape.getMotions().get(i).getWidthEnd(), shape.getMotions().get(i).getHeightEnd()),
                      new Color(shape.getMotions().get(i).getRedEnd(),
                              shape.getMotions().get(i).getGreenEnd(), shape.getMotions().get(i).getBlueEnd()))));
    }
    return motions;
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
  public IShapeAnimation clone() {
    return null;
  }
}
