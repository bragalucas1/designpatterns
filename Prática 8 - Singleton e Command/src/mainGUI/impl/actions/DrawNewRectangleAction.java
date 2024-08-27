package mainGUI.impl.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.AppDoc;
import mainGUI.impl.MainGUI;
import mainGUI.impl.dialog.Cores;
import mainGUI.impl.dialog.DialogoBase;
import mainGUI.impl.dialog.DialogoRetangulo;
import fig.interfaces.RectangleInterface;

public class DrawNewRectangleAction extends DrawNewFigAction {
	
	public DrawNewRectangleAction() {
		super("Rectangle");		
	}

	public void actionPerformed(ActionEvent arg0) {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc doc = mainGUI.getActiveDoc();
		DialogoRetangulo d = new DialogoRetangulo(mainGUI);
		if (d.showModal() == DialogoBase.OK) {
			int posX = d.getX();
			int posY = d.getY();
			Color color = Cores.getCor(d.getCor());
			int larg = d.getLargura();
			int alt = d.getAltura();
			RectangleInterface rect =
				mainGUI.getFigFactory().createRectangle(posX, posY, color, larg, alt);
			doc.getFigList().addFig(rect);
			doc.setModified(true);
			DrawNewRectangleAction newAction = new DrawNewRectangleAction();
			newAction.fig = rect;
			mainGUI.addCommand(newAction);
			mainGUI.refresh();
		}
	}

}
