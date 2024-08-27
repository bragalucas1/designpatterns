package mainGUI.framework;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import util.MyFileFilter;

public abstract class MainGUIFramework extends JFrame {

	private static MainGUIFramework instance = null;
	private static boolean allowConstrutor = false;

	public synchronized static MainGUIFramework getInstance() {
		synchronized (MainGUIFramework.class) {
			if (instance == null) {
				File file = new File("src\\");
				try {
					URL url = file.toURI().toURL();
					URL[] urls = new URL[] { url };
					ClassLoader loader = new URLClassLoader(urls);
					String s = System.getenv("INF494GUI");

					// Retire o coment�rio da linha abaixo, caso esteja tendo
					// dificuldades para definir o valor da vari�vel de sistema
					// que indica qual � a classe a ser usada como GUI.
					s = "mainGUI.impl.MainGUI";

					if (s == null) {
						throw new RuntimeException(
								"Name of the main GUI must be defined in system variable 'INF494GUI'");
					}
					Class cls = loader.loadClass(s);
					allowConstrutor = true;
					instance = (MainGUIFramework) cls.getConstructor().newInstance();
					allowConstrutor = false;
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
			return instance;
		}

	}

	private String docPrefix = "NewDoc", fileMenuTitle = "File", drawMenuTitle = "Draw", newfigMenuTitle = "New Figure";
	private AppDoc appDoc;
	private int indexNew;
	private JPanel panel;
	private AbstractAction drawEditAction, drawRemoveAction, drawNewCircleAction, drawNewRectangleAction,
			drawNewLineAction, undoAction, redoAction, exitAction, fileNewAction, fileOpenAction, fileSaveAction,
			fileSaveAsAction;
	private JFileChooser fileChooser;
	private MyFileFilter filter;

	// Hist�rico de comandos
	private List<UndoRedoInterface> commandHistory;

	// �ndice do primeiro comando que poder� ser desfeito
	private int indexCommand;

	public abstract AbstractAction createDrawNewLineAction();

	public abstract AbstractAction createDrawEditAction();

	public abstract AbstractAction createDrawNewCircleAction();

	public abstract AbstractAction createDrawNewRectangleAction();

	public abstract AbstractAction createDrawRemoveAction();

	public abstract AbstractAction createUndoAction();

	public abstract AbstractAction createRedoAction();

	public abstract AbstractAction createExitAction();

	public abstract AbstractAction createFileNewAction();

	public abstract AbstractAction createFileOpenAction();

	public abstract AbstractAction createFileSaveAction();

	public abstract AbstractAction createFileSaveAsAction();

	protected MainGUIFramework() {
		synchronized (MainGUIFramework.class) {

			if (!allowConstrutor) {
				throw new RuntimeException("Constructor not available. Use MainGUIFramework.getInstance()");
			}

			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					tryClose();
				}
			});

			drawEditAction = createDrawEditAction();
			drawRemoveAction = createDrawRemoveAction();
			drawNewLineAction = createDrawNewLineAction();
			drawNewCircleAction = createDrawNewCircleAction();
			drawNewRectangleAction = createDrawNewRectangleAction();
			undoAction = createUndoAction();
			redoAction = createRedoAction();
			exitAction = createExitAction();
			fileNewAction = createFileNewAction();
			fileOpenAction = createFileOpenAction();
			fileSaveAction = createFileSaveAction();
			fileSaveAsAction = createFileSaveAsAction();

			appDoc = createNewDocument();
			appDoc.setModified(false);
			appDoc.setNewDoc(true);
			indexNew = 1;
			appDoc.setURL(docPrefix + indexNew);
			setTitle(appDoc.getURL());
			panel = createPanel();
			add(panel);

			MenuBar menuBar = new MenuBar(this);
			setJMenuBar(menuBar);
			ToolBar toolBar = new ToolBar(this);
			add(toolBar, BorderLayout.PAGE_START);

			filter = new MyFileFilter();
			filter.addExtension("xml");
			filter.setDescription("XML files");

			commandHistory = new java.util.ArrayList<UndoRedoInterface>();
			indexCommand = -1;

			refresh();
		}

	}

	public void tryClose() {
		if (getActiveDoc().isModified()) {
			int resp = JOptionPane.showConfirmDialog(this, "Deseja gravar o arquivo?", "Arquivo alterado",
					JOptionPane.YES_NO_CANCEL_OPTION);
			if (resp == JOptionPane.YES_OPTION) {
				if (!saveFile()) {
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

	public JPanel createPanel() {
		return new JPanel();
	}

	public void refresh() {
		String name = getActiveDoc().getURL();
		if (getActiveDoc().isModified()) {
			name = "* " + name;
		}
		setTitle(name);
		undoAction.setEnabled(indexCommand >= 0);
		redoAction.setEnabled(indexCommand < commandHistory.size() - 1);
		repaint();
	}

	public JPanel getPanel() {
		return panel;
	}

	private boolean verifModified() {
		if (!appDoc.isModified()) {
			return true;
		}
		int resp = JOptionPane.showConfirmDialog(this, "Arquivo foi modificado - deseja gravar?", "Verifica��o",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (resp == JOptionPane.CANCEL_OPTION) {
			return false;
		}
		if (resp == JOptionPane.YES_OPTION) {
			saveFile();
		}
		return true;
	}

	public AppDoc createNewDocument() {
		return new AppDoc();
	}

	public boolean newFile() {
		if (!verifModified()) {
			return false;
		}
		++indexNew;
		String docName = docPrefix + indexNew;
		appDoc = createNewDocument();
		appDoc.setURL(docName);
		setTitle(docName);
		appDoc.setNewDoc(true);
		appDoc.setModified(false);
		refresh();
		return true;
	}

	public boolean saveAsFile() {
		fileChooser = new JFileChooser(new File("xmlfiles"));
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showSaveDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String docName = fileChooser.getSelectedFile().getAbsolutePath();
			appDoc = createNewDocument();
			appDoc.setURL(docName);
			setTitle(docName);
			appDoc.setModified(false);
			appDoc.setNewDoc(false);
			refresh();
			return true;
		}
		return false;
	}

	public boolean saveFile() {
		if (appDoc.isNewDoc()) {
			return saveAsFile();
		}
		appDoc.setModified(false);
		refresh();
		return true;
	}

	public boolean openFile() {
		if (!verifModified()) {
			return false;
		}
		JFileChooser fileChooser = new JFileChooser(new File("xmlfiles"));
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String docName = fileChooser.getSelectedFile().getAbsolutePath();
			appDoc = createNewDocument();
			appDoc.setURL(docName);
			setTitle(docName);
			appDoc.setNewDoc(false);
			appDoc.setModified(false);
			refresh();
			return true;
		} else {
			return false;
		}
	}

	// ----------------------- UNDO / REDO ------------------------------------

	// Attention:
	// indexCommand is the position of the first command that can be undone

	public void addCommand(UndoRedoInterface c) {
		++indexCommand;
		while (commandHistory.size() > indexCommand) {
			commandHistory.remove(indexCommand);
		}
		commandHistory.add(c);
		refresh();
	}

	public void undoCommand() {
		if (indexCommand < 0) {
			return;
		}
		UndoRedoInterface c = commandHistory.get(indexCommand);
		c.undo();
		--indexCommand;
		refresh();
	}

	public void redoCommand() {
		if (indexCommand >= commandHistory.size() - 1) {
			return;
		}
		++indexCommand;
		UndoRedoInterface c = commandHistory.get(indexCommand);
		c.redo();
		refresh();
	}

	// -----------------------------------------------------------

	public AbstractAction getDrawEditAction() {
		return drawEditAction;
	}

	public AbstractAction getDrawRemoveAction() {
		return drawRemoveAction;
	}

	public AbstractAction getDrawNewCircleAction() {
		return drawNewCircleAction;
	}

	public AbstractAction getDrawNewRectangleAction() {
		return drawNewRectangleAction;
	}

	public AbstractAction getDrawNewLineAction() {
		return drawNewLineAction;
	}

	public AbstractAction getUndoAction() {
		return undoAction;
	}

	public AbstractAction getRedoAction() {
		return redoAction;
	}

	public AbstractAction getExitAction() {
		return exitAction;
	}

	public AbstractAction getFileNewAction() {
		return fileNewAction;
	}

	public AbstractAction getFileOpenAction() {
		return fileOpenAction;
	}

	public AbstractAction getFileSaveAction() {
		return fileSaveAction;
	}

	public AbstractAction getFileSaveAsAction() {
		return fileSaveAsAction;
	}

	public String getDocPrefix() {
		return docPrefix;
	}

	public void setDocPrefix(String docPrefix) {
		this.docPrefix = docPrefix;
	}

	public String getFileMenuTitle() {
		return fileMenuTitle;
	}

	public void setFileMenuTitle(String fileMenuTitle) {
		this.fileMenuTitle = fileMenuTitle;
	}

	public String getDrawMenuTitle() {
		return drawMenuTitle;
	}

	public void setDrawMenuTitle(String drawMenuTitle) {
		this.drawMenuTitle = drawMenuTitle;
	}

	public String getNewfigMenuTitle() {
		return newfigMenuTitle;
	}

	public void setNewfigMenuTitle(String newfigMenuTitle) {
		this.newfigMenuTitle = newfigMenuTitle;
	}

	public AppDoc getActiveDoc() {
		return appDoc;
	}

	public void setActiveDoc(AppDoc appDoc) {
		this.appDoc = appDoc;
	}

}
