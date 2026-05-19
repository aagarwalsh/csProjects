package cs3500.turtle.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import cs3500.turtle.control.commands.Koch;
import cs3500.turtle.control.commands.Move;
import cs3500.turtle.control.commands.Retrieve;
import cs3500.turtle.control.commands.Save;
import cs3500.turtle.control.commands.Square;
import cs3500.turtle.control.commands.Trace;
import cs3500.turtle.control.commands.Turn;
import cs3500.turtle.tracingmodel.TracingTurtleModel;
import cs3500.turtle.view.IView;

/**
 * This is a controller that is very similar to the
 * CommandController class. The main difference
 * is that the main is replaced with the controller
 * method processCommand
 */
public class MVCCommandController implements IController, ActionListener {
  private final TracingTurtleModel model;
  private final IView view;

  public MVCCommandController(TracingTurtleModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  @Override
  public void go() {
    this.view.setCommandButtonListener(this);
    this.view.makeVisible();
  }

  @Override
  public String processCommand(String command) {
    if (command == null || command.trim().isEmpty()) {
      throw new IllegalArgumentException("Enter a turtle command.");
    }

    StringBuilder output = new StringBuilder();
    Scanner s = new Scanner(command);

    while (s.hasNext()) {
      String in = s.next();
      TracingTurtleCommand cmd;

      switch (in) {
        case "move":
          cmd = new Move(nextDouble(s, in));
          break;
        case "trace":
          cmd = new Trace(nextDouble(s, in));
          break;
        case "turn":
          cmd = new Turn(nextDouble(s, in));
          break;
        case "square":
          cmd = new Square(nextDouble(s, in));
          break;
        case "koch":
          cmd = new Koch(nextDouble(s, in), nextInt(s, in));
          break;
        case "save":
          cmd = new Save();
          break;
        case "retrieve":
          cmd = new Retrieve();
          break;
        default:
          throw new IllegalArgumentException(String.format("Unknown command: %s", in));
      }
      cmd.go(model);
      if (output.length() > 0) {
        output.append(System.lineSeparator());
      }
      output.append(String.format("Executed: %s", in));
    }

    return output.toString();
  }

  private static double nextDouble(Scanner scanner, String commandName) {
    if (!scanner.hasNextDouble()) {
      throw new IllegalArgumentException(
              String.format("Expected a number after %s.", commandName));
    }
    return scanner.nextDouble();
  }

  private static int nextInt(Scanner scanner, String commandName) {
    if (!scanner.hasNextInt()) {
      throw new IllegalArgumentException(
              String.format("Expected a whole-number depth after %s.", commandName));
    }
    return scanner.nextInt();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = view.getTurtleCommand();
    String status;

    try {
      status = processCommand(command);
      view.showStatusMessage(status);
    } catch (Exception ex) {
      view.showErrorMessage(ex.getMessage());
    }
    view.setLines(model.getLines());
    //set turtle position and heading
    view.setTurtlePosition(model.getPosition());
    view.setTurtleHeading(model.getHeading());
    view.refresh();
  }
}
