package mainGUI.impl;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.bind.JAXBException;

import fig.adapterJaxb.Adapter;
import fig.draw.Exhibitor;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.xmlclasses.FigDoc;
import mainGUI.framework.MainGUIFramework;
import mainGUI.impl.actions.DrawEditAction;
import mainGUI.impl.actions.DrawNewCircleAction;
import mainGUI.impl.actions.DrawNewLineAction;
import mainGUI.impl.actions.DrawNewRectangleAction;
import mainGUI.impl.actions.DrawRemoveAction;
import mainGUI.impl.actions.ExitAction;
import mainGUI.impl.actions.FileNewAction;
import mainGUI.impl.actions.FileOpenAction;
import mainGUI.impl.actions.FileSaveAction;
import mainGUI.impl.actions.FileSaveAsAction;
import mainGUI.impl.actions.RedoAction;
import mainGUI.impl.actions.UndoAction;
import util.JaxbOperations;

public class MainGUI extends MainGUIFramework {

	private JaxbOperations jop;

	private FigFactoryInterface figFactory;

	public MainGUI() {
		try {
			figFactory = new fig.adapterJaxb.FigFactory();
			jop = new JaxbOperations("fig.xmlclasses", "src/xsd/fig.xsd");
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public JPanel createPanel(mainGUI.framework.AppDoc appDoc) {
		return new Exhibitor((AppDoc) appDoc);
	}

	public AppDoc getActiveDoc() {
		return (AppDoc) super.getActiveDoc();
	}

	public Exhibitor getActivePanel() {
		return (Exhibitor) super.getActivePanel();
	}

	public AppDoc createDocument() {
		return new AppDoc();
	}

	public boolean newFile() {
		if (super.newFile()) {
			AppDoc appDoc = getActiveDoc();
			FigListInterface figList = figFactory.createFigList();
			appDoc.setFigList(figList);
			refresh(appDoc);
			return true;
		}
		return false;
	}

	public boolean openFile() {
		if (!super.openFile()) {
			return false;
		}
		try {
			AppDoc appDoc = getActiveDoc();
			FigDoc figDoc = (FigDoc) jop.readObject(appDoc.getURL());
			FigListInterface figList = Adapter.adapt(figDoc.getFigList());
			appDoc.setFigList(figList);
			refresh(appDoc);
			return true;
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(this, e, "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public boolean saveAsFile() {
		if (!super.saveAsFile()) {
			return false;
		}
		try {
			FigDoc doc = new FigDoc();
			FigListInterface figList = getActiveDoc().getFigList();
			doc.setFigList(((fig.adapterJaxb.FigList) figList).getFigListType());
			jop.writeObject(getActiveDoc().getURL(), doc);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e, "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean saveFile() {
		if (super.saveFile()) {
			try {
				FigListInterface figList = getActiveDoc().getFigList();
				FigDoc doc = new FigDoc();
				doc.setFigList(((fig.adapterJaxb.FigList) figList).getFigListType());
				jop.writeObject(getActiveDoc().getURL(), doc);
				return true;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e, "ERRO", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public AbstractAction createDrawEditAction() {
		return new DrawEditAction();
	}

	@Override
	public AbstractAction createDrawNewCircleAction() {
		return new DrawNewCircleAction();
	}

	@Override
	public AbstractAction createDrawNewRectangleAction() {
		return new DrawNewRectangleAction();
	}

	@Override
	public AbstractAction createDrawRemoveAction() {
		return new DrawRemoveAction();
	}

	@Override
	public AbstractAction createUndoAction() {
		return new UndoAction();
	}

	@Override
	public AbstractAction createRedoAction() {
		return new RedoAction();
	}

	@Override
	public AbstractAction createExitAction() {
		return new ExitAction();
	}

	@Override
	public AbstractAction createFileNewAction() {
		return new FileNewAction();
	}

	@Override
	public AbstractAction createFileOpenAction() {
		return new FileOpenAction();
	}

	@Override
	public AbstractAction createFileSaveAction() {
		return new FileSaveAction();
	}

	@Override
	public AbstractAction createFileSaveAsAction() {
		return new FileSaveAsAction();
	}

	public FigFactoryInterface getFigFactory() {
		return figFactory;
	}

	@Override
	public AbstractAction createDrawNewLineAction() {
		return new DrawNewLineAction();
	}

}
