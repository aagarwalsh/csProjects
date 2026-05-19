package cs3500.animator.model;

import java.util.ArrayList;

import cs3500.animator.util.AnimationBuilder;

/**
 * Class to represent a model for an animation. The list of shapes represents a list of images to be
 * placed upon a background. The canvas represents the background the animation takes place on. The
 * tick represents the current time in the animation.
 */
public class AnimationModelImpl implements AnimationModel {


  protected ArrayList<AbstractShape> shapes;
  protected Canvas c;


  /**
   * Constructor for this implementation of the AnimationModel.
   *
   * @param builder represents a Builder that holds the values for the fields of the model.
   */
  private AnimationModelImpl(Builder builder) {
    this.shapes = builder.shapes;
    this.c = builder.c;
  }


  @Override
  public Canvas getCanvas() {
    return this.c;
  }

  @Override
  public ArrayList<AbstractShape> getShapes() {
    return this.shapes;
  }

  @Override
  public void addKeyFrame(String label, int tick, int x, int y, int w, int h, int r, int g, int b) {
    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i).label.equals(label)) {
        for (int j = 0; j < shapes.get(i).getMotions().size() - 1; j++) {
          if (shapes.get(i).getMotions().get(j).getTickStart() < tick &&
                  (shapes.get(i).getMotions().get(j).getTickEnd() > tick)) {

            Motion m = new Motion(tick, x, y, w, h, r, g, b,
                    shapes.get(i).getMotions().get(j).getTickEnd(),
                    shapes.get(i).getMotions().get(j).getPosXEnd(),
                    shapes.get(i).getMotions().get(j).getPosYEnd(),
                    shapes.get(i).getMotions().get(j).getWidthEnd(),
                    shapes.get(i).getMotions().get(j).getHeightEnd(),
                    shapes.get(i).getMotions().get(j).getRedEnd(),
                    shapes.get(i).getMotions().get(j).getGreenEnd(),
                    shapes.get(i).getMotions().get(j).getBlueEnd());
            this.shapes.get(i).getMotions().add(j, m);
            shapes.get(i).getMotions().get(j).tickEnd = tick;
          }

          if (shapes.get(i).getMotions().get(j).getTickEnd() > tick &&
                  (shapes.get(i).getMotions().get(j + 1).getTickStart() < tick)) {
            Motion m = new Motion(tick, x, y, w, h, r, g, b,
                    shapes.get(i).getMotions().get(j + 1).getTickEnd(),
                    shapes.get(i).getMotions().get(j + 1).getPosXEnd(),
                    shapes.get(i).getMotions().get(j + 1).getPosYEnd(),
                    shapes.get(i).getMotions().get(j + 1).getWidthEnd(),
                    shapes.get(i).getMotions().get(j + 1).getHeightEnd(),
                    shapes.get(i).getMotions().get(j + 1).getRedEnd(),
                    shapes.get(i).getMotions().get(j + 1).getGreenEnd(),
                    shapes.get(i).getMotions().get(j + 1).getBlueEnd());
            this.shapes.get(i).getMotions().add(j + 1, m);
          }

          if (tick < shapes.get(i).getMotions().get(0).getTickStart()) {
            Motion m = new Motion(tick, x, y, w, h, r, g, b,
                    shapes.get(i).getMotions().get(0).getTickEnd(),
                    shapes.get(i).getMotions().get(0).getPosXEnd(),
                    shapes.get(i).getMotions().get(0).getPosYEnd(),
                    shapes.get(i).getMotions().get(0).getWidthEnd(),
                    shapes.get(i).getMotions().get(0).getHeightEnd(),
                    shapes.get(i).getMotions().get(0).getRedEnd(),
                    shapes.get(i).getMotions().get(0).getGreenEnd(),
                    shapes.get(i).getMotions().get(0).getBlueEnd());
            this.shapes.get(i).getMotions().add(0, m);
          }


        }
      }
    }
  }

  @Override
  public void removeKeyFrame(String label,
                             int tick, int x, int y, int w, int h, int r, int g, int b) {
    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i).label.equals(label)) {
        for (int j = 0; j < shapes.get(i).getMotions().size(); j++) {

          if (shapes.get(i).getMotions().get(j).tickStart == tick &&
                  j != shapes.get(i).getMotions().size() - 1) {
            Motion add = new Motion(shapes.get(i).getMotions().get(j).tickEnd,
                    shapes.get(i).getMotions().get(j).posXEnd,
                    shapes.get(i).getMotions().get(j).posYEnd,
                    shapes.get(i).getMotions().get(j).widthEnd,
                    shapes.get(i).getMotions().get(j).heightEnd,
                    shapes.get(i).getMotions().get(j).redEnd,
                    shapes.get(i).getMotions().get(j).greenEnd,
                    shapes.get(i).getMotions().get(j).blueEnd,
                    shapes.get(i).getMotions().get(j + 1).tickStart,
                    shapes.get(i).getMotions().get(j + 1).posX,
                    shapes.get(i).getMotions().get(j + 1).posY,
                    shapes.get(i).getMotions().get(j + 1).width,
                    shapes.get(i).getMotions().get(j + 1).height,
                    shapes.get(i).getMotions().get(j + 1).red,
                    shapes.get(i).getMotions().get(j + 1).green,
                    shapes.get(i).getMotions().get(j + 1).blue);
            shapes.get(i).motions.add(j + 1, add);
            shapes.get(i).motions.remove(shapes.get(i).getMotions().get(j));
          }

          if (shapes.get(i).getMotions().get(j).tickEnd == tick &&
                  j == shapes.get(i).getMotions().size() - 1) {
            Motion add = new Motion(shapes.get(i).getMotions().get(j - 1).tickEnd,
                    shapes.get(i).getMotions().get(j - 1).posXEnd,
                    shapes.get(i).getMotions().get(j - 1).posYEnd,
                    shapes.get(i).getMotions().get(j - 1).widthEnd,
                    shapes.get(i).getMotions().get(j - 1).heightEnd,
                    shapes.get(i).getMotions().get(j - 1).redEnd,
                    shapes.get(i).getMotions().get(j - 1).greenEnd,
                    shapes.get(i).getMotions().get(j - 1).blueEnd,
                    shapes.get(i).getMotions().get(j).tickStart,
                    shapes.get(i).getMotions().get(j).posX,
                    shapes.get(i).getMotions().get(j).posY,
                    shapes.get(i).getMotions().get(j).width,
                    shapes.get(i).getMotions().get(j).height,
                    shapes.get(i).getMotions().get(j).red,
                    shapes.get(i).getMotions().get(j).green,
                    shapes.get(i).getMotions().get(j).blue);
            shapes.get(i).motions.add(j, add);
            shapes.get(i).motions.remove(shapes.get(i).getMotions().get(j + 1));
          }

          if (shapes.get(i).getMotions().get(j).tickEnd == tick &&
                  j != shapes.get(i).getMotions().size() - 1) {
            Motion add = new Motion(shapes.get(i).getMotions().get(j).tickStart,
                    shapes.get(i).getMotions().get(j).posX,
                    shapes.get(i).getMotions().get(j).posY,
                    shapes.get(i).getMotions().get(j).width,
                    shapes.get(i).getMotions().get(j).height,
                    shapes.get(i).getMotions().get(j).red,
                    shapes.get(i).getMotions().get(j).green,
                    shapes.get(i).getMotions().get(j).blue,
                    shapes.get(i).getMotions().get(j + 1).tickStart,
                    shapes.get(i).getMotions().get(j + 1).posX,
                    shapes.get(i).getMotions().get(j + 1).posY,
                    shapes.get(i).getMotions().get(j + 1).width,
                    shapes.get(i).getMotions().get(j + 1).height,
                    shapes.get(i).getMotions().get(j + 1).red,
                    shapes.get(i).getMotions().get(j + 1).green,
                    shapes.get(i).getMotions().get(j + 1).blue);
            shapes.get(i).motions.add(j, add);
            shapes.get(i).motions.remove(shapes.get(i).getMotions().get(j + 1));
          }
        }
      }
    }
  }

  @Override
  public void addShape(ShapeNames type, String label) {
    for (int i = 0; i < this.shapes.size(); i++) {
      if (this.shapes.get(i).label.equals(label)) {
        throw new IllegalArgumentException("Sir, that shape is already in use!");
      } else {
        switch (type.value) {
          case "rectangle":
            this.shapes.add(new Rectangle(ShapeNames.rect, label));
            break;
          case "circle":
            this.shapes.add(new Ellipse(ShapeNames.circle, label));
            break;

          case "ellipse":
            this.shapes.add(new Ellipse(ShapeNames.ellipse, label));
            break;
          case "square":
            this.shapes.add(new Rectangle(ShapeNames.square, label));
            break;

          default:
            break;
        }
      }
    }
  }

  @Override
  public void removeShape(ShapeNames type, String label) {
    for (int i = 0; i < this.shapes.size(); i++) {
      if (this.shapes.get(i).label.equals(label)) {
        this.shapes.remove(i);
      } else {
        throw new IllegalArgumentException("Sir, that shape does not exist!");
      }
    }
  }


  /**
   * An implementation of AnimationBuilder to help develop the fields of the Model.
   */
  public static final class Builder implements AnimationBuilder<AnimationModel> {

    public ArrayList<AbstractShape> shapes;
    public Canvas c;


    public Builder() {
      this.shapes = new ArrayList<>();
    }

    @Override
    public AnimationModel build() {

      return new AnimationModelImpl(this);
    }

    @Override
    public AnimationBuilder<AnimationModel> setBounds(int x, int y, int width, int height) {
      this.c = new Canvas(x, y, width, height);
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> declareShape(String name, String type) {
      switch (type) {
        case "rectangle":
          this.shapes.add(new Rectangle(ShapeNames.rect, name));
          break;
        case "circle":
          this.shapes.add(new Ellipse(ShapeNames.circle, name));
          break;

        case "ellipse":
          this.shapes.add(new Ellipse(ShapeNames.ellipse, name));
          break;
        case "square":
          this.shapes.add(new Rectangle(ShapeNames.square, name));
          break;

        default:
          break;
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addMotion(String name,
                                                      int t1, int x1, int y1, int w1, int h1,
                                                      int r1, int g1, int b1, int t2, int x2,
                                                      int y2, int w2, int h2, int r2, int g2,
                                                      int b2) {

      for (AbstractShape s : this.shapes) {
        if (s.label.equals(name)) {
          s.motions.add(new Motion(t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2));
        }
      }
      return this;
    }

    @Override
    public AnimationBuilder<AnimationModel> addKeyframe(String name, int t, int x, int y,
                                                        int w, int h, int r, int g, int b) {
      throw new UnsupportedOperationException();
    }
  }

}
