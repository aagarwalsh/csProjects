package cs3500.animator.provider.view;

import cs3500.animator.provider.model.Color;
import cs3500.animator.provider.model.Dimension2D;
import cs3500.animator.provider.model.IViewModel;
import cs3500.animator.provider.model.Pos2D;
import cs3500.animator.provider.shape.IShapeAnimation;
import cs3500.animator.provider.shape.ShapeAnimationFactory;
import cs3500.animator.provider.shape.ShapeType;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

/**
 * View for animation that uses Java swing to display the animation. Also allows user interaction
 * to edit the animation.
 */
public class EditorView extends VisualView {
  private static final int START_TICK = 1;
  private JButton playButton;
  private JButton pauseButton;
  private JButton restartButton;
  private JButton increaseSpeedButton;
  private JButton decreaseSpeedButton;
  private JButton removeShapeButton;
  private JButton addShapeButton;
  private JButton addKeyframeButton;
  private JButton editKeyframeButton;
  private JButton removeKeyframeButton;
  private JToggleButton loopToggleButton;
  private JToggleButton showSelectedToggleButton;
  private JComboBox<ShapeType> shapeTypesJCB;
  private JComboBox<String> shapeSelectorJCB;
  private JTextField addShapeName;
  private JTextField keyframeTick;
  private JTextField keyframeX;
  private JTextField keyframeY;
  private JTextField keyframeWidth;
  private JTextField keyframeHeight;
  private JTextField keyframeR;
  private JTextField keyframeG;
  private JTextField keyframeB;
  private JLabel currentTickLabel;

  /**
   * Constructs a VisualView instance and sets its fields with the given values.
   *
   * @param viewModel instance of object adapter class for model
   */
  public EditorView(IViewModel viewModel) throws IllegalArgumentException {
    super();
    if (viewModel == null) {
      throw new IllegalArgumentException("viewModel cannot be null.");
    }
    this.viewModel = viewModel;
    // Panels
    JPanel editPanel = new JPanel(new GridLayout(17, 1));

    this.panel.setPreferredSize(new Dimension(this.viewModel.getCanvasWidth(),
        this.viewModel.getCanvasHeight()));

    JScrollPane scrollPane = new JScrollPane(panel, VERTICAL_SCROLLBAR_AS_NEEDED,
        HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBar(scrollPane.createHorizontalScrollBar());
    scrollPane.setVerticalScrollBar(scrollPane.createVerticalScrollBar());

    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(scrollPane, BorderLayout.CENTER);

    // Toggle Button
    this.loopToggleButton = new JToggleButton("Toggle Looping");
    this.loopToggleButton.setActionCommand("Loop Toggle Button");
    this.showSelectedToggleButton = new JToggleButton("Show Selected");
    this.showSelectedToggleButton.setActionCommand("Show Selected Button");


    // Buttons
    this.playButton = new JButton("Play");
    this.playButton.setActionCommand("Play Button");
    this.pauseButton = new JButton("Pause");
    this.pauseButton.setActionCommand("Pause Button");
    this.restartButton = new JButton("Restart");
    this.restartButton.setActionCommand("Restart Button");
    this.increaseSpeedButton = new JButton("Speed Up");
    this.increaseSpeedButton.setActionCommand("Speed Up Button");
    this.decreaseSpeedButton = new JButton("Slow Down");
    this.decreaseSpeedButton.setActionCommand("Slow Down Button");
    this.addShapeButton = new JButton("Add Shape");
    this.addShapeButton.setActionCommand("Add Shape Button");
    this.removeShapeButton = new JButton("Remove Selected Shape");
    this.removeShapeButton.setActionCommand("Remove Shape Button");
    this.addKeyframeButton = new JButton("Add Keyframe");
    this.addKeyframeButton.setActionCommand("Add Keyframe Button");
    this.editKeyframeButton = new JButton("Edit Keyframe");
    this.editKeyframeButton.setActionCommand("Edit Keyframe Button");
    this.removeKeyframeButton = new JButton("Remove Keyframe");
    this.removeKeyframeButton.setActionCommand("Remove Keyframe Button");

    // Combo Boxes
    this.shapeTypesJCB = new JComboBox<>(ShapeType.values());
    this.shapeSelectorJCB = new JComboBox<>(this.viewModel.getShapeNames());

    // Text Fields
    this.addShapeName = new JTextField(8);
    this.keyframeTick = new JTextField(3);
    this.keyframeX = new JTextField(3);
    this.keyframeY = new JTextField(3);
    this.keyframeWidth = new JTextField(3);
    this.keyframeHeight = new JTextField(3);
    this.keyframeR = new JTextField(3);
    this.keyframeG = new JTextField(3);
    this.keyframeB = new JTextField(3);

    // JLabels
    this.currentTickLabel = new JLabel("Current Tick: " + START_TICK);

    // Edit Panel
    JPanel playbackPanel = new JPanel(new GridLayout(1, 3));
    playbackPanel.add(this.playButton);
    playbackPanel.add(this.pauseButton);
    playbackPanel.add(this.restartButton);
    editPanel.add(playbackPanel);
    JPanel speedPanel = new JPanel(new GridLayout(1, 2));
    speedPanel.add(this.increaseSpeedButton);
    speedPanel.add(this.decreaseSpeedButton);
    editPanel.add(speedPanel);
    editPanel.add(this.loopToggleButton);
    editPanel.add(new JLabel(""));

    JPanel shapeSelectPanel = new JPanel();
    shapeSelectPanel.setLayout(new BoxLayout(shapeSelectPanel, BoxLayout.X_AXIS));
    shapeSelectPanel.add(new JLabel("Shape selector: "));
    shapeSelectPanel.add(this.shapeSelectorJCB);
    shapeSelectPanel.add(this.showSelectedToggleButton);
    editPanel.add(shapeSelectPanel);
    editPanel.add(new JLabel(""));

    editPanel.add(this.removeShapeButton);
    editPanel.add(new JLabel(""));
    JPanel addShapePanel = new JPanel();
    addShapePanel.setLayout(new BoxLayout(addShapePanel, BoxLayout.X_AXIS));
    addShapePanel.add(new JLabel("Name: "));
    addShapePanel.add(this.addShapeName);
    addShapePanel.add(this.shapeTypesJCB);
    addShapePanel.add(this.addShapeButton);
    editPanel.add(addShapePanel);
    editPanel.add(new JLabel(""));
    JPanel keyframeButtonsPanel = new JPanel(new GridLayout(1, 3));
    keyframeButtonsPanel.add(this.addKeyframeButton);
    keyframeButtonsPanel.add(this.editKeyframeButton);
    keyframeButtonsPanel.add(this.removeKeyframeButton);
    editPanel.add(keyframeButtonsPanel);
    JPanel keyframeTickPanel = new JPanel();
    keyframeTickPanel.setLayout(new BoxLayout(keyframeTickPanel, BoxLayout.X_AXIS));
    keyframeTickPanel.add(new JLabel("Keyframe Tick: "));
    keyframeTickPanel.add(this.keyframeTick);
    JPanel keyframePosPanel = new JPanel();
    keyframePosPanel.setLayout(new BoxLayout(keyframePosPanel, BoxLayout.X_AXIS));
    keyframePosPanel.add(new JLabel("Keyframe Position (x, y): "));
    keyframePosPanel.add(this.keyframeX);
    keyframePosPanel.add(this.keyframeY);
    JPanel keyframeDimPanel = new JPanel();
    keyframeDimPanel.setLayout(new BoxLayout(keyframeDimPanel, BoxLayout.X_AXIS));
    keyframeDimPanel.add(new JLabel("Keyframe Size (width, height): "));
    keyframeDimPanel.add(this.keyframeWidth);
    keyframeDimPanel.add(this.keyframeHeight);
    JPanel keyframeColorPanel = new JPanel();
    keyframeColorPanel.setLayout(new BoxLayout(keyframeColorPanel, BoxLayout.X_AXIS));
    keyframeColorPanel.add(new JLabel("Keyframe Color (r, g, b): "));
    keyframeColorPanel.add(this.keyframeR);
    keyframeColorPanel.add(this.keyframeG);
    keyframeColorPanel.add(this.keyframeB);
    editPanel.add(keyframeTickPanel);
    editPanel.add(keyframePosPanel);
    editPanel.add(keyframeDimPanel);
    editPanel.add(keyframeColorPanel);
    editPanel.add(new JLabel(""));
    JPanel currentTickPanel = new JPanel(new FlowLayout());
    currentTickPanel.add(this.currentTickLabel);
    editPanel.add(currentTickPanel);

    this.add(editPanel, BorderLayout.EAST);
    this.pack();
    this.setVisible(true);
  }

  @Override
  public void setActionListener(ActionListener clicks) {
    this.playButton.addActionListener(clicks);
    this.pauseButton.addActionListener(clicks);
    this.restartButton.addActionListener(clicks);
    this.increaseSpeedButton.addActionListener(clicks);
    this.decreaseSpeedButton.addActionListener(clicks);
    this.loopToggleButton.addActionListener(clicks);
    this.showSelectedToggleButton.addActionListener(clicks);
    this.removeShapeButton.addActionListener(clicks);
    this.addShapeButton.addActionListener(clicks);
    this.addKeyframeButton.addActionListener(clicks);
    this.editKeyframeButton.addActionListener(clicks);
    this.removeKeyframeButton.addActionListener(clicks);
  }

  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void display() {
    throw new UnsupportedOperationException("display() not supported for EditorView.");
  }

  @Override
  public void displayAtTick(int tick) {
    this.currentTickLabel.setText(String.format("Current Tick: %d", tick));
    this.panel.draw(viewModel.getShapes(tick), this.showSelectedToggleButton.isSelected());
  }

  @Override
  public String shapeToRemove() {
    String name = this.shapeSelected();
    this.shapeSelectorJCB.removeItem(name);
    return name;
  }

  @Override
  public String shapeSelected() {
    return this.shapeSelectorJCB.getItemAt(this.shapeSelectorJCB.getSelectedIndex());
  }

  @Override
  public IShapeAnimation shapeToAdd() throws IllegalArgumentException {
    String name = this.addShapeName.getText();
    if (this.viewModel.getShapeAnimations().containsKey(name)) {
      throw new IllegalArgumentException(String.format("Shape with name %s already exists.",
          name));
    }

    IShapeAnimation shapeAnimation = ShapeAnimationFactory.makeShapeAnimation(name,
        this.shapeTypesJCB.getItemAt(this.shapeTypesJCB.getSelectedIndex()));
    this.addNameToShapesJComboBox(name);
    return shapeAnimation;
  }

  private void addNameToShapesJComboBox(String name) {
    int ii = 0;
    while (ii < this.shapeSelectorJCB.getItemCount()) {
      if (name.compareTo(this.shapeSelectorJCB.getItemAt(ii)) <= 0) {
        this.shapeSelectorJCB.insertItemAt(name, ii);
        return;
      }
      ii++;
    }
    this.shapeSelectorJCB.addItem(name);
  }

  @Override
  public boolean hasListeners() {
    return true;
  }

  @Override
  public boolean isLoopingEnabled() {
    return this.loopToggleButton.isSelected();
  }

  @Override
  public int keyframeTick() {
    return Integer.parseInt(this.keyframeTick.getText());
  }

  @Override
  public Pos2D keyframePos() {
    String x = this.keyframeX.getText();
    String y = this.keyframeY.getText();
    if (x.equals("") || y.equals("")) {
      return null;
    }
    return new Pos2D(Integer.parseInt(x), Integer.parseInt(y));
  }

  @Override
  public Dimension2D keyframeDim() {
    String width = this.keyframeWidth.getText();
    String height = this.keyframeHeight.getText();
    if (width.equals("") || height.equals("")) {
      return null;
    }
    return new Dimension2D(Integer.parseInt(width), Integer.parseInt(height));
  }

  @Override
  public Color keyframeColor() {
    String r = this.keyframeR.getText();
    String g = this.keyframeG.getText();
    String b = this.keyframeB.getText();
    if (r.equals("") || g.equals("") || b.equals("")) {
      return null;
    }
    return new Color(Integer.parseInt(r), Integer.parseInt(g), Integer.parseInt(b));
  }
}