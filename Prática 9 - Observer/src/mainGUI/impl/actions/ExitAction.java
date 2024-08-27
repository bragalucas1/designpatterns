package mainGUI.impl.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import mainGUI.framework.AppDoc;
import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.MainGUI;

public class ExitAction extends AbstractAction {
	
	public ExitAction() {
		super("Exit");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc appDoc = mainGUI.getActiveDoc();
		if (appDoc == null) {
			System.exit(0);			
		}
		if (appDoc.isModified()) {
			int resp = JOptionPane.showConfirmDialog(mainGUI,
					"Deseja gravar o arquivo?",
					"Arquivo alterado",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (resp == JOptionPane.YES_OPTION) {
				if (!mainGUI.saveFile()) {
					resp = JOptionPane.CANCEL_OPTION;
				}
			}
			if (resp != JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
		} else {
			System.exit(0);
		}
	}

}
