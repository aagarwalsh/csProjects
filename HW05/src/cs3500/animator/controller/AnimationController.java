package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.ShapeNames;
import cs3500.animator.view.IView;

/**
 * this class represents the controller for the animation. It forms the connection between the view
 * and model and transmits the information from the model to the view. It also handles the
 * commands/actions performed by the user in terms of the buttons, eg: start and pause.
 */
public class AnimationController implements ActionListener {
  protected IView view;
  protected AnimationModel model;
  protected Timer timer;

  /**
   * This is the contructor for the controller.
   *
   * @param v represents the view of the animation.
   * @param m represents the model of the animation.
   */
  public AnimationController(IView v, AnimationModel m) {
    this.view = v;
    this.model = m;
    timer = new Timer(view.getSpeed(), view.getPanel());
    this.view.setListeners(this);

    if (view.isVisual()) {
      timer.start();
    }

  }

  /**
   * Processes the command input.
   *
   * @param command the string to be processed.
   * @return the command after being processed.
   */
  public String processCommand(String command) {
    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);
    return output.toString();
  }

  /**
   * helps determine the action performed by the user and updates the appropriate information based
   * on the command.
   *
   * @param e represents the ActionEvent being processed.
   */
  public void actionPerformed(ActionEvent e) {
    String keyFrameCommand = this.view.getKeyFrameCommand();
    String shapeCommand = this.view.getShapeCommand();
    switch (e.getActionCommand()) {
      case "Start Button":
        this.timer.start();
        break;
      case "Pause Button":
        this.timer.stop();
        break;
      case "Restart Button":
        this.timer.restart();
        view.setTick(0);
        break;

      case "Resume Button":
        this.timer.start();
        break;

      case "Increase Speed Button":
        this.timer.setDelay(timer.getDelay() / 2);
        break;

      case "Decrease Speed Button":
        this.timer.setDelay(timer.getDelay() * 2);
        break;

      case "Looping Button":
        if (timer.isRepeats()) {
          timer.setRepeats(false);
          if (timer.isRunning()) {
            timer.restart();
            view.setTick(0);
            timer.setRepeats(true);
          }
        }
        break;

      case "Add KeyFrame":
        processedKFCommand(keyFrameCommand, "add");
        view.setShapes(model.getShapes());
        break;

      case "Remove KeyFrame":
        processedKFCommand(keyFrameCommand, "remove");
        view.setShapes(model.getShapes());
        break;

      case "Add Shape":
        processShapeCmd(shapeCommand, "add");
        view.setShapes(model.getShapes());
        break;

      case "Remove Shape":
        processShapeCmd(shapeCommand, "remove");
        view.setShapes(model.getShapes());
        break;


      default:
        break;
    }

    view.refresh();

  }

  void processedKFCommand(String command, String method) {
    String[] cmds = command.split(" ");
    String label = cmds[0];
    int tick = Integer.parseInt(cmds[1]);
    int x = Integer.parseInt(cmds[2]);
    int y = Integer.parseInt(cmds[3]);
    int w = Integer.parseInt(cmds[4]);
    int h = Integer.parseInt(cmds[5]);
    int r = Integer.parseInt(cmds[6]);
    int g = Integer.parseInt(cmds[7]);
    int b = Integer.parseInt(cmds[8]);

    if (method.equals("add")) {
      model.addKeyFrame(label, tick, x, y, w, h, r, g, b);
    }
    if (method.equals("remove")) {
      model.removeKeyFrame(label, tick, x, y, w, h, r, g, b);
    }
  }

  void processShapeCmd(String command, String method) {
    String[] cmds = command.split(" ");
    String label = cmds[0];
    String type = cmds[1];
    ShapeNames typeS = null;

    switch (type) {
      case "rectangle":
        typeS = ShapeNames.rect;
        break;
      case "square":
        typeS = ShapeNames.square;
        break;
      case "circle":
        typeS = ShapeNames.circle;
        break;
      case "ellipse":
        typeS = ShapeNames.ellipse;
        break;
      default:
        break;
    }

    if (method.equals("add")) {
      model.addShape(typeS, label);
    }

    if (method.equals("remove")) {
      model.removeShape(typeS, label);
    }

  }

  /**
   * Gets the information regarding the canvas and shapes from the model and transmits it to the
   * view. It also makes the animation visible - for text it prints out a stream but does nothing
   * for svg.
   */
  public void goControl() {
    view.setShapes(model.getShapes());
    view.setCanvas(model.getCanvas());
    this.view.makeVisible();
  }


}
