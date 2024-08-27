package mainGUI.framework;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import observer.Observer;
import observer.Subject;
import util.MyFileFilter;


public abstract class MainGUIFramework extends JFrame {
	
	private static MainGUIFramework instance;
	private static boolean permiteConstrutor = false;
	
	public synchronized static MainGUIFramework getInstance() {
		synchronized (MainGUIFramework.class) {
			if (instance == null) {
				File file = new File("src\\");			    
			    try {
			        URL url = file.toURI().toURL();
			        URL[] urls = new URL[]{url};
			        ClassLoader loader = new URLClassLoader(urls);
					String s = System.getenv("INF494GUI");
					
					// Retire o comentário da linha abaixo, caso esteja tendo
					// dificuldades para definir o valor da variável de sistema
					// que indica qual é a classe a ser usada como GUI.
					
					// s = "mainGUI.impl.MainGUI";
					
					if (s == null) {
				    	throw new RuntimeException("Name of the main GUI must be defined in system variable 'INF494GUI'");
					}
			        Class cls = loader.loadClass(s);
			        permiteConstrutor = true;
					instance = (MainGUIFramework) cls.getConstructor().newInstance();
					permiteConstrutor = false;
			    } catch (Exception e) {
			    	throw new RuntimeException(e.getMessage());
			    }
			}
			return instance;
		}

		

	}

	private String
		docPrefix = "NewDoc",
		fileMenuTitle = "File",
		drawMenuTitle = "Draw",
		newfigMenuTitle = "New Figure";
	private int indexNew;
	private AbstractAction
		drawEditAction, drawRemoveAction,
		drawNewCircleAction, drawNewRectangleAction,
		undoAction, redoAction, exitAction,
		fileNewAction, fileOpenAction, fileSaveAction, fileSaveAsAction;
	private JFileChooser fileChooser;
	private MyFileFilter filter; 	
	private JDesktopPane desktop;

	
	private class InternalFrame
	extends JInternalFrame implements Observer {
		
		private AppDoc appDoc;
		private JPanel panel;
		
		private class InternalFrameListener
		extends InternalFrameAdapter {
			
			private InternalFrameListener() {
			}
			
			public void internalFrameActivated(InternalFrameEvent e) {
				refresh();
			}

			public void internalFrameDeactivated(InternalFrameEvent e) {
				refresh();
			}

			public void internalFrameClosed(InternalFrameEvent e) {
				refresh();
				appDoc.detach(InternalFrame.this);
			}
		}
		
		public InternalFrame(AppDoc doc, JPanel panel) {
			super(doc.getURL(), true, true, true, true);
			setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
			this.appDoc = doc;
			this.panel = panel;
			addInternalFrameListener(new InternalFrameListener());
			add(panel, BorderLayout.CENTER);
			setSize(600, 300);
		}
		
		public void tryClose() {
			boolean b = verifModified(appDoc);
			if (b) {
				try {
					dispose();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		public AppDoc getDoc() {
			return appDoc;
		}
		
		public JPanel getPanel() {
			return panel;
		}
		
		public void update(Subject subject) {
			String name = appDoc.getURL();
			if (appDoc.isModified()) {
				name = "* " + name;
			}
			setTitle(name);
			repaint();
		}

	}
	
	
	public abstract JPanel createPanel(AppDoc appDoc);
	public abstract AppDoc createDocument();

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


	public MainGUIFramework() {
		synchronized (MainGUIFramework.class) {
			
			if (!permiteConstrutor) {
				throw new RuntimeException("Não permite acessar construtor!");
			}
			
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			
		    addWindowListener(
		    		new WindowAdapter() {
		    			public void windowClosing(WindowEvent e) {
		    				tryClose();
		    	        }
		    		}
			    );
		    
		    drawEditAction = createDrawEditAction();
		    drawRemoveAction = createDrawRemoveAction();
		    drawNewCircleAction = createDrawNewCircleAction();
		    drawNewRectangleAction = createDrawNewRectangleAction();
		    undoAction = createUndoAction();
		    redoAction = createRedoAction();
		    exitAction = createExitAction();
		    fileNewAction = createFileNewAction();
		    fileOpenAction = createFileOpenAction();
		    fileSaveAction = createFileSaveAction();
		    fileSaveAsAction = createFileSaveAsAction();
		    		
			desktop = new JDesktopPane();
			add(desktop);
	
		    indexNew = 1;
			
			MenuBar menuBar = new MenuBar(this);
			setJMenuBar(menuBar);
			ToolBar toolBar = new ToolBar(this);
	        add(toolBar, BorderLayout.PAGE_START);
	        
			filter = new MyFileFilter();
			filter.addExtension("xml");
			filter.setDescription("XML files");
	
		    refresh();
		}
	    
	}
	
	public void tryClose() {
		JInternalFrame [] frames = desktop.getAllFrames();
		for (JInternalFrame f : frames) {
			((InternalFrame) f).tryClose();
			// se algum frame não for realmente fechado,
			// então a aplicação nao será encerrada
			if (! f.isClosed()) {
				return;
			}
		}
		System.exit(0);
	}
			
	private void refresh() {
		AppDoc appDoc = getActiveDoc();
		undoAction.setEnabled(appDoc != null && appDoc.hasUndo());
		redoAction.setEnabled(appDoc != null && appDoc.hasRedo());
		drawNewCircleAction.setEnabled(appDoc != null);
		drawNewRectangleAction.setEnabled(appDoc != null);
		fileSaveAction.setEnabled(appDoc != null);
		fileSaveAsAction.setEnabled(appDoc != null);
	}
	
	public void refresh(AppDoc appDoc) {
		refresh();
		appDoc.notifyObservers();
	}

	private boolean verifModified(AppDoc appDoc) {
		if (!appDoc.isModified()) {
			return true;
		}
		int resp = JOptionPane.showConfirmDialog(this,
			"Arquivo "
				+ appDoc.getURL()
				+ " foi modificado - deseja gravar?",
			"Verificação",
			JOptionPane.YES_NO_CANCEL_OPTION);
		if (resp == JOptionPane.CANCEL_OPTION) {
			return false;
		}
		if (resp == JOptionPane.YES_OPTION) {
			saveFile();
		}
		return true;
	}
	
	private void createFrame(AppDoc appDoc) {
		JPanel panel = createPanel(appDoc);
		InternalFrame frame = new InternalFrame(appDoc, panel);
		desktop.add(frame);
		frame.setVisible(true);
		appDoc.attach(frame);
	}
	
	public boolean newFile() {
		AppDoc appDoc = createDocument();
	    appDoc.setModified(false);
	    appDoc.setNewDoc(true);
	    appDoc.setURL(docPrefix + indexNew);
		++indexNew;
		createFrame(appDoc);
		refresh(appDoc);
		return true;
	}
	
	public boolean saveAsFile() {
		fileChooser = new JFileChooser(new File("xmlfiles"));
		fileChooser.setFileFilter(filter);
	    int returnVal = fileChooser.showSaveDialog(this);
	    if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	String docName = fileChooser.getSelectedFile().getAbsolutePath();
	    	AppDoc appDoc = getActiveDoc();
	    	appDoc.setURL(docName);
		    getActiveFrame().setTitle(docName);
		    appDoc.setModified(false);
		    appDoc.setNewDoc(false);
		    refresh(appDoc);
	    	return true;
	    }
	    return false;
	}
	
	public boolean saveFile() {
		AppDoc appDoc = getActiveDoc();
		if (appDoc.isNewDoc()) {
			return saveAsFile();
		}
		appDoc.setModified(false);
		refresh(appDoc);
		return true;
	}
	
	public boolean openFile() {
		JFileChooser fileChooser = new JFileChooser(new File("xmlfiles"));
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String docName =
					fileChooser.getSelectedFile().getAbsolutePath();
			
			JInternalFrame [] frames = desktop.getAllFrames();
			InternalFrame f1 = null;
			for (JInternalFrame f : frames) {
				InternalFrame f2 = (InternalFrame) f;
				if (f2.getDoc().getURL().equalsIgnoreCase(docName)) {
					f1 = f2;
					break;
				}
			}
			if (f1 != null) {
				AppDoc appDoc = f1.getDoc();
				createFrame(appDoc);
				refresh(appDoc);
				return false;
			}
			
			AppDoc appDoc = createDocument();
			appDoc.setURL(docName);
			appDoc.setNewDoc(false);
			appDoc.setModified(false);
			createFrame(appDoc);
			refresh(appDoc);
			return true;
		} else {
			return false;
		}
	}
	
	public void addCommand(UndoRedoInterface c) {
		getActiveDoc().addCommand(c);
	}
	
	public void undoCommand() {
		AppDoc appDoc = getActiveDoc();
		appDoc.undoCommand();
		refresh(appDoc);
	}

	public void redoCommand() {
		AppDoc appDoc = getActiveDoc();
		appDoc.redoCommand();
		refresh(appDoc);
	}

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
	public InternalFrame getActiveFrame() {
		return (InternalFrame) desktop.getSelectedFrame();
	}
	public AppDoc getActiveDoc() {
		InternalFrame frame = getActiveFrame();
		if (frame == null) {
			return null;
		}
		return frame.getDoc();
	}
	public JPanel getActivePanel() {
		InternalFrame frame = getActiveFrame();
		if (frame == null) {
			return null;
		}
		return frame.getPanel();
	}

}
