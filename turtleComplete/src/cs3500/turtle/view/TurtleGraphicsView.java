package cs3500.turtle.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cs3500.turtle.model.Position2D;
import cs3500.turtle.tracingmodel.Line;

/**
 * This is an implementation of the IView interface
 * that uses Java Swing to draw the results of the
 * turtle. It shows any error messages using a
 * pop-up dialog box, and shows the turtle position
 * and heading
 */
public class TurtleGraphicsView extends JFrame implements IView {
  private final JButton commandButton;
  private final JButton quitButton;
  private final JPanel buttonPanel;
  private final TurtlePanel turtlePanel;
  private final JTextField input;
  private final JLabel display;

  public TurtleGraphicsView() {
    super();
    this.setTitle("TurtleComplete");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    turtlePanel = new TurtlePanel();
    turtlePanel.setPreferredSize(new Dimension(500, 500));
    this.add(turtlePanel, BorderLayout.CENTER);

    //button panel
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    display = new JLabel("Ready");
    this.add(display, BorderLayout.NORTH);

    input = new JTextField(24);
    buttonPanel.add(input);

    commandButton = new JButton("Execute");
    buttonPanel.add(commandButton);

    //quit button
    quitButton = new JButton("Quit");
    quitButton.addActionListener((ActionEvent e) -> {
      System.exit(0);
    });
    buttonPanel.add(quitButton);

    this.pack();


  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }


  @Override
  public void setCommandButtonListener(ActionListener actionEvent) {
    commandButton.addActionListener(actionEvent);
    input.addActionListener(actionEvent);
  }

  @Override
  public String getTurtleCommand() {
    String command = this.input.getText();
    this.input.setText("");
    return command;
  }

  @Override
  public void setLines(List<Line> lines) {
    turtlePanel.setLines(lines);
  }

  @Override
  public void setTurtlePosition(Position2D pos) {
    turtlePanel
            .setTurtlePosition(pos);
  }

  @Override
  public void setTurtleHeading(double headingDegrees) {
    turtlePanel
            .setTurtleHeading(headingDegrees);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void showErrorMessage(String error) {
    display.setText("Error: " + error);
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void showStatusMessage(String status) {
    display.setText(status);
  }

}
