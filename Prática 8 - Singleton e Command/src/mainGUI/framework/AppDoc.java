package mainGUI.framework;

public class AppDoc {
	
	private boolean modified, newDoc;
	private String url;
	
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

}
