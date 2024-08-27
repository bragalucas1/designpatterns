package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class FileOpenAction extends AbstractAction {
	
	public FileOpenAction() {
		super("Open");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		mainGUI.openFile();
	}

}
