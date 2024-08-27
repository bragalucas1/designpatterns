package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class FileSaveAction extends AbstractAction {

	public FileSaveAction() {
		super("Save");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		mainGUI.saveFile();
	}

}
