package mainGUI.framework;

import java.util.List;

import observer.Observer;
import observer.Subject;
import observer.SubjectImpl;

public class AppDoc implements Subject {
	
	private boolean modified, newDoc;
	private String url;
	
	// Histórico de comandos
	private List<UndoRedoInterface> commandHistory;
	
	// Índice do primeiro comando que poderá ser desfeito
	private int indexCommand;

	private Subject subject;
	
	public AppDoc() {
		commandHistory = new java.util.ArrayList<UndoRedoInterface>();
		indexCommand = -1;
		modified = newDoc = false;
		url = "";
		subject = new SubjectImpl();
	}
	
	public void addCommand(UndoRedoInterface c) {
		++indexCommand;
		while (commandHistory.size() > indexCommand) {
			commandHistory.remove(indexCommand);
		}
		commandHistory.add(c);
	}

	public boolean hasUndo() {
		return indexCommand >= 0;
	}
	
	public boolean hasRedo() {
		return indexCommand < commandHistory.size() - 1;
	}
	
	public void undoCommand() {
		UndoRedoInterface c = commandHistory.get(indexCommand);
		c.undo();
		--indexCommand;
	}

	public void redoCommand() {
		++indexCommand;
		UndoRedoInterface c = commandHistory.get(indexCommand);
		c.redo();
	}

	
	public String getURL() {
		return url;
	}
	public void setURL(String url) {
		this.url = url;
	}
	public boolean isModified() {
		return modified;
	}
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	public boolean isNewDoc() {
		return newDoc;
	}
	public void setNewDoc(boolean newDoc) {
		this.newDoc = newDoc;
	}

	public void attach(Observer observer) {
		subject.attach(observer);
	}

	public void detach(Observer observer) {
		subject.detach(observer);
	}

	public void notifyObservers() {
		subject.notifyObservers();
	}

}
