package cs3500.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JOptionPane;

import cs3500.animator.adapter.ModelAdapter;
import cs3500.animator.adapter.ViewModel;
import cs3500.animator.controller.AnimationController;
import cs3500.animator.controller.ProviderController;
import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.AnimationModelImpl;
import cs3500.animator.provider.model.IAnimatorModel;
import cs3500.animator.provider.model.IViewModel;
import cs3500.animator.provider.view.IAnimatorView;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.IView;
import cs3500.animator.view.SVGView;
import cs3500.animator.view.TextualView;
import cs3500.animator.view.VisualView;

/**
 * Main class to run the animation.
 */
public class Excellence {

  /**
   * Main method to run animation.
   *
   * @param args input by user.
   */
  public static void main(String[] args) {
    String in = getArg(args, "-in");
    String out = getArg(args, "-out");
    String viewName = getArg(args, "-view");
    int speed = parseSpeed(getArg(args, "-speed"));

    if (in == null || viewName == null) {
      showError("Usage: -in <file> -view <text|svg|visual|edit|provider> "
              + "[-out <file>] [-speed <ticks-per-second>]");
      return;
    }

    Readable rd;
    try {
      rd = new FileReader(in);
    } catch (FileNotFoundException f) {
      showError("Input file not found: " + in);
      return;
    }

    AnimationReader ar = new AnimationReader();
    AnimationModel model = ar.parseFile(rd, new AnimationModelImpl.Builder());
    IView view;

    switch (viewName) {
      case "text":
        view = new TextualView();
        break;
      case "svg":
        view = new SVGView();
        break;
      case "visual":
        view = new VisualView();
        break;
      case "edit":
        view = new cs3500.animator.view.EditorView("Easy Animator Editor");
        break;
      case "provider":
        IAnimatorModel modelAdapter = new ModelAdapter(model);
        IViewModel viewModel = new ViewModel(modelAdapter);
        IAnimatorView providerView = new cs3500.animator.provider.view.EditorView(viewModel);
        new ProviderController(providerView).go();
        return;
      default:
        showError("Invalid view: " + viewName);
        return;
    }

    view.setSpeed(speed);
    AnimationController controller = new AnimationController(view, model);
    controller.goControl();

    if (out != null) {
      if (viewName.equals("svg")) {
        SVGView.toFile(((SVGView) view).xMLCommands(), out);
      }
      if (viewName.equals("text")) {
        TextualView.toFile(((TextualView) view).printView(), out);
      }
    }
  }

  private static String getArg(String[] args, String flag) {
    for (int i = 0; i < args.length - 1; i++) {
      if (flag.equals(args[i])) {
        return args[i + 1];
      }
    }
    return null;
  }

  private static int parseSpeed(String speed) {
    if (speed == null) {
      return 100;
    }
    try {
      int parsed = Integer.parseInt(speed);
      if (parsed <= 0) {
        throw new IllegalArgumentException();
      }
      return parsed;
    } catch (IllegalArgumentException e) {
      showError("Speed must be a positive integer.");
      return 100;
    }
  }

  private static void showError(String message) {
    System.err.println(message);
    if (!java.awt.GraphicsEnvironment.isHeadless()) {
      JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}
