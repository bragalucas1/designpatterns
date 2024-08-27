package mainGUI.impl;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.bind.JAXBException;

import draw.Exibidor;
import fig.adapterJaxb.Adapter;
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

	private Exibidor exibidor;

	public MainGUI() {
		try {
			figFactory = new fig.adapterJaxb.FigFactory();
			jop = new JaxbOperations("fig.xmlclasses", "src/xsd/fig.xsd");
			exibidor = (Exibidor) getPanel();
			FigListInterface figList = figFactory.createFigList();
			getActiveDoc().setFigList(figList);
			exibidor.setFigList(figList);
			refresh();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public JPanel createPanel() {
		return new Exibidor();
	}

	public AppDoc getActiveDoc() {
		return (AppDoc) super.getActiveDoc();
	}

	public AppDoc createNewDocument() {
		return new AppDoc();
	}

	public boolean newFile() {
		if (super.newFile()) {
			FigListInterface figList = figFactory.createFigList();
			getActiveDoc().setFigList(figList);
			exibidor.setFigList(getActiveDoc().getFigList());
			refresh();
			return true;
		}
		return false;
	}

	public boolean openFile() {
		AppDoc old = getActiveDoc();
		if (!super.openFile()) {
			return false;
		}
		try {
			FigDoc figDoc = (FigDoc) jop.readObject(getActiveDoc().getURL());
			FigListInterface figList = Adapter.adapt(figDoc.getFigList());
			exibidor.setFigList(figList);
			getActiveDoc().setFigList(figList);
			return true;
		} catch (JAXBException e) {
			setActiveDoc(old);
			JOptionPane.showMessageDialog(this, e, "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean saveAsFile() {
		AppDoc old = getActiveDoc();
		FigListInterface figList = old.getFigList();
		if (!super.saveAsFile()) {
			return false;
		}
		try {
			FigDoc doc = new FigDoc();
			doc.setFigList(((fig.adapterJaxb.FigList) figList).getFigListType());
			jop.writeObject(getActiveDoc().getURL(), doc);
			getActiveDoc().setFigList(figList);
			return true;
		} catch (Exception e) {
			setActiveDoc(old);
			JOptionPane.showMessageDialog(this, e, "ERRO", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean saveFile() {
		AppDoc old = getActiveDoc();
		FigListInterface figList = old.getFigList();
		boolean resp = super.saveFile();
		if (resp) {
			try {
				FigDoc doc = new FigDoc();
				doc.setFigList(((fig.adapterJaxb.FigList) figList).getFigListType());
				jop.writeObject(getActiveDoc().getURL(), doc);
				getActiveDoc().setFigList(figList);
				return true;
			} catch (Exception e) {
				setActiveDoc(old);
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
