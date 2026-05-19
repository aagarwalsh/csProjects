package cs3500.animator.provider.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * EditorView listener class for dealing with actions performed.
 */
public class EditorViewListener implements ActionListener {
  private Map<String, Runnable> editorViewActions;

  /**
   * Empty default constructor.
   */
  public EditorViewListener() {
    // empty constructor
  }

  /**
   * Set the map for key typed events. Key typed events in Java Swing are characters.
   */
  public void setEditorViewActionMap(Map<String, Runnable> map) {
    editorViewActions = map;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (editorViewActions.containsKey(e.getActionCommand())) {
      editorViewActions.get(e.getActionCommand()).run();
    }
  }
}