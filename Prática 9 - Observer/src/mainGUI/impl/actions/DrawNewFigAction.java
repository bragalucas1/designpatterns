package mainGUI.impl.actions;

import javax.swing.AbstractAction;

import mainGUI.framework.MainGUIFramework;
import mainGUI.framework.UndoRedoInterface;
import mainGUI.impl.AppDoc;
import mainGUI.impl.MainGUI;

import fig.interfaces.FigInterface;

public abstract class DrawNewFigAction
extends AbstractAction
implements UndoRedoInterface {

	protected FigInterface fig;
	
	public DrawNewFigAction(String s) {
		super(s);
	}
	
	public void undo() {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc doc = mainGUI.getActiveDoc();
		doc.getFigList().removeFig(fig);
	}
	
	public void redo() {
		MainGUI mainGUI = (MainGUI) MainGUIFramework.getInstance();
		AppDoc doc = mainGUI.getActiveDoc();
		doc.getFigList().addFig(fig);
	}

}
