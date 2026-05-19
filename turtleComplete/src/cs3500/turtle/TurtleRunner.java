import cs3500.turtle.control.IController;
import cs3500.turtle.control.MVCCommandController;
import cs3500.turtle.tracingmodel.SmarterTurtle;
import cs3500.turtle.tracingmodel.TracingTurtleModel;
import cs3500.turtle.view.IView;
import cs3500.turtle.view.TurtleGraphicsView;

/**
 * Application entry point for the turtle graphics demo.
 */
public class TurtleRunner {
  public static void main(String[] args) {
    TracingTurtleModel model = new SmarterTurtle();
    IView view = new TurtleGraphicsView();
    IController controller = new MVCCommandController(model, view);
    controller.go();
  }
}
