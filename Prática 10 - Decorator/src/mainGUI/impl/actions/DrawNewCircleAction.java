package mainGUI.impl.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.AppDoc;
import mainGUI.impl.MainGUI;
import mainGUI.impl.dialog.Cores;
import mainGUI.impl.dialog.DialogoBase;
import mainGUI.impl.dialog.DialogoCirculo;

import fig.interfaces.CircleInterface;

public class DrawNewCircleAction
extends DrawNewFigAction {
	
	public DrawNewCircleAction() {
		super("Circle");
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc appDoc = mainGUI.getActiveDoc();
		DialogoCirculo d = new DialogoCirculo(mainGUI);
		if (d.showModal() == DialogoBase.OK) {
			int posX = d.getX();
			int posY = d.getY();
			Color color = Cores.getCor(d.getCor());
			int radius = d.getRaio();
			CircleInterface circle =
				mainGUI.getFigFactory().createCircle(posX, posY, color, radius);
			appDoc.getFigList().addFig(circle);
			appDoc.setModified(true);
			DrawNewCircleAction newAction = new DrawNewCircleAction();
			newAction.fig = circle;
			mainGUI.addCommand(newAction);
			mainGUI.refresh(appDoc);
		}
	}
	
}
