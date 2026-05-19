package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cs3500.animator.model.AbstractShape;
import cs3500.animator.model.Canvas;

/**
 * Represents one implementation of the IView interface. It allows the user to interact with the
 * animation and perform functions such as pausing the animation and restarting it. It also allows
 * the user to add or delete KeyFrames.
 */
public class EditorView extends JFrame implements IView {
  private VisualPanel panel;
  private JTextField keyFrameInput;
  private JTextField shapesInput;
  private JButton startButton;
  private JButton pauseButton;
  private JButton resumeButton;
  private JButton restartButton;
  private JButton loopingButton;
  private JButton increaseSpeed;
  private JButton decreaseSpeed;
  private JButton addKeyFrame;
  private JButton removeKeyFrame;
  private JButton addShape;
  private JButton removeShape;


  /**
   * A constructor for the editor view.
   *
   * @param s represents the string input of the user.
   */
  public EditorView(String s) {

    super(s);
    JLabel keyframeLabel;
    JLabel shapesLabel;
    JPanel buttonPanel;
    JPanel keyFramePanel;
    JPanel shapesPanel;
    JPanel shapesAndKeysPanel;
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    this.panel = new VisualPanel();
    shapesAndKeysPanel = new JPanel();
    buttonPanel = new JPanel();
    keyFramePanel = new JPanel();
    keyFramePanel.setLayout(new FlowLayout());

    shapesPanel = new JPanel();
    shapesPanel.setLayout(new FlowLayout());
    this.panel.setPreferredSize(new Dimension(1000, 1000));

    this.add(this.panel, BorderLayout.CENTER);
    this.add(buttonPanel, BorderLayout.SOUTH);
    this.add(shapesAndKeysPanel, BorderLayout.NORTH);
    shapesAndKeysPanel.add(keyFramePanel, BorderLayout.SOUTH);
    shapesAndKeysPanel.add(shapesPanel, BorderLayout.NORTH);

    keyframeLabel = new JLabel("Keyframe:");
    keyFramePanel.add(keyframeLabel);

    keyFrameInput = new JTextField(10);
    keyFramePanel.add(keyFrameInput);

    shapesLabel = new JLabel("Shape:");
    shapesPanel.add(shapesLabel);

    shapesInput = new JTextField(10);
    shapesPanel.add(shapesInput);


    //buttons
    startButton = new JButton("Start");
    startButton.setActionCommand("Start Button");
    buttonPanel.add(startButton);

    pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("Pause Button");
    buttonPanel.add(pauseButton);

    resumeButton = new JButton("Resume");
    resumeButton.setActionCommand("Resume Button");
    buttonPanel.add(resumeButton);

    restartButton = new JButton("Restart");
    restartButton.setActionCommand("Restart Button");
    buttonPanel.add(restartButton);

    loopingButton = new JButton("Loop");
    loopingButton.setActionCommand("Looping Button");
    buttonPanel.add(loopingButton);

    increaseSpeed = new JButton("Increase Speed");
    increaseSpeed.setActionCommand("Increase Speed Button");
    buttonPanel.add(increaseSpeed);

    decreaseSpeed = new JButton("Decrease Speed");
    decreaseSpeed.setActionCommand("Decrease Speed Button");
    buttonPanel.add(decreaseSpeed);

    addKeyFrame = new JButton("Add");
    addKeyFrame.setActionCommand("Add KeyFrame");
    keyFramePanel.add(addKeyFrame);

    removeKeyFrame = new JButton("Remove");
    removeKeyFrame.setActionCommand("Remove KeyFrame");
    keyFramePanel.add(removeKeyFrame);

    addShape = new JButton("Add");
    addShape.setActionCommand("Add Shape");
    shapesPanel.add(addShape);

    removeShape = new JButton("Remove");
    removeShape.setActionCommand("Remove Shape");
    shapesPanel.add(removeShape);


    this.pack();

  }


  @Override
  public void makeVisible() {
    setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void addShapes(AbstractShape shape) {
    this.panel.addShape(shape);
  }

  @Override
  public void setShapes(ArrayList<AbstractShape> shapes) {
    this.panel.shapes = shapes;

  }

  @Override
  public void setCanvas(Canvas c) {
    this.panel.canvas = c;

  }

  @Override
  public String getKeyFrameCommand() {
    String command = this.keyFrameInput.getText();
    this.keyFrameInput.setText("");
    return command;
  }

  @Override
  public String getShapeCommand() {
    String command = this.shapesInput.getText();
    this.shapesInput.setText("");
    return command;
  }

  @Override
  public void setTick(int tick) {
    this.panel.tick = tick;

  }

  @Override
  public VisualPanel getPanel() {
    return this.panel;
  }

  @Override
  public void setListeners(ActionListener clicks) {
    this.startButton.addActionListener(clicks);
    this.pauseButton.addActionListener(clicks);
    this.restartButton.addActionListener(clicks);
    this.resumeButton.addActionListener(clicks);
    this.loopingButton.addActionListener(clicks);
    this.increaseSpeed.addActionListener(clicks);
    this.decreaseSpeed.addActionListener(clicks);
    this.addKeyFrame.addActionListener(clicks);
    this.removeKeyFrame.addActionListener(clicks);
    this.addShape.addActionListener(clicks);
    this.removeShape.addActionListener(clicks);

  }

  @Override
  public void setSpeed(int speed) {
    this.panel.speed = speed;
  }

  @Override
  public int getSpeed() {
    return this.panel.speed;
  }

  @Override
  public boolean isVisual() {
    return false;
  }
}
