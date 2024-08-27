package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class FileSaveAsAction extends AbstractAction {

	public FileSaveAsAction() {
		super("Save as");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		mainGUI.saveAsFile();
	}

}
