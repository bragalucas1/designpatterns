package mainGUI.framework;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	public ToolBar(MainGUIFramework mainGUI) {
		super(mainGUI.getDrawMenuTitle());
	    add(new JButton(mainGUI.getDrawNewCircleAction()));
	    add(new JButton(mainGUI.getDrawNewRectangleAction()));
	    add(new JButton(mainGUI.getUndoAction()));
	    add(new JButton(mainGUI.getRedoAction()));
	    setVisible(true);
	}
}
