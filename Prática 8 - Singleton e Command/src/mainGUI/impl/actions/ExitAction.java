package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class ExitAction extends AbstractAction {
	
	public ExitAction() {
		super("Exit");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		mainGUI.tryClose();
	}

}
