package mainGUI.framework;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	public ToolBar(MainGUIFramework mainGUIframework) {
		super(mainGUIframework.getDrawMenuTitle());
		add(new JButton(mainGUIframework.getDrawNewCircleAction()));
		add(new JButton(mainGUIframework.getDrawNewRectangleAction()));
		add(new JButton(mainGUIframework.getDrawNewLineAction()));
		add(new JButton(mainGUIframework.getUndoAction()));
		add(new JButton(mainGUIframework.getRedoAction()));
		setVisible(true);
	}
}
