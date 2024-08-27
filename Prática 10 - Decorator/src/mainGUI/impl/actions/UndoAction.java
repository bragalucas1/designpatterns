package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class UndoAction extends AbstractAction {
	
	public UndoAction() {
		super("Undo");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		mainGUI.undoCommand();
	}

}
