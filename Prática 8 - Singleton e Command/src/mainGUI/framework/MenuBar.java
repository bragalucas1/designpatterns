package mainGUI.framework;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

	public MenuBar(MainGUIFramework mainGUI) {
		JMenu m1 = new JMenu(mainGUI.getFileMenuTitle());
		JMenuItem m1_1 = new JMenuItem(mainGUI.getFileNewAction());
		JMenuItem m1_2 = new JMenuItem(mainGUI.getFileOpenAction());
		JMenuItem m1_3 = new JMenuItem(mainGUI.getFileSaveAction());
		JMenuItem m1_4 = new JMenuItem(mainGUI.getFileSaveAsAction());
		JMenuItem m1_5 = new JMenuItem(mainGUI.getExitAction());
		m1.add(m1_1);
		m1.add(m1_2);
		m1.add(m1_3);
		m1.add(m1_4);
		m1.add(m1_5);
		add(m1);
		JMenu m2 = new JMenu(mainGUI.getDrawMenuTitle());
		JMenu m2_1 = new JMenu(mainGUI.getNewfigMenuTitle());
		JMenuItem m2_1_1 = new JMenuItem(mainGUI.getDrawNewCircleAction());
		JMenuItem m2_1_2 = new JMenuItem(mainGUI.getDrawNewRectangleAction());
		JMenuItem m2_1_3 = new JMenuItem(mainGUI.getDrawNewLineAction());
		m2_1.add(m2_1_1);
		m2_1.add(m2_1_2);
		m2_1.add(m2_1_3);
		m2.add(m2_1);
		JMenuItem m2_2 = new JMenuItem(mainGUI.getDrawEditAction());
		m2.add(m2_2);
		JMenuItem m2_3 = new JMenuItem(mainGUI.getDrawRemoveAction());
		m2.add(m2_3);
		add(m2);
		JMenuItem m2_4 = new JMenuItem(mainGUI.getUndoAction());
		m2.add(m2_4);
		JMenuItem m2_5 = new JMenuItem(mainGUI.getRedoAction());
		m2.add(m2_5);
	}

}
