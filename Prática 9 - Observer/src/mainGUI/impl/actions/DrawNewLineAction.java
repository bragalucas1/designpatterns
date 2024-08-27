package mainGUI.impl.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import fig.interfaces.LineInterface;
import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.AppDoc;
import mainGUI.impl.MainGUI;
import mainGUI.impl.dialog.Cores;
import mainGUI.impl.dialog.DialogoBase;
import mainGUI.impl.dialog.DialogoLinha;

public class DrawNewLineAction extends DrawNewFigAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawNewLineAction() {
		super("Line");
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc doc = mainGUI.getActiveDoc();
		DialogoLinha l = new DialogoLinha(mainGUI);
		if (l.showModal() == DialogoBase.OK) {
			int posX = l.getX();
			int posY = l.getY();
			int posX2 = l.getX2();
			int posY2 = l.getY2();
			Color color = Cores.getCor(l.getCor());
			LineInterface line = mainGUI.getFigFactory().createLine(posX, posY, color, posX2, posY2);
			doc.getFigList().addFig(line);
			doc.setModified(true);
			DrawNewCircleAction newAction = new DrawNewCircleAction();
			newAction.fig = line;
			mainGUI.addCommand(newAction);
			mainGUI.refresh(doc);
		}
	}

}
