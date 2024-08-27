package mainGUI.impl;

import fig.adapterJaxb.Adapter;
import fig.interfaces.FigListInterface;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.ObjectFactory;

public class AppDoc extends mainGUI.framework.AppDoc {

	private FigListInterface figList;
		
	public FigListInterface getFigList() {
		return figList;
	}
	
	public void setFigList(FigListInterface figList) {
		this.figList = figList;
	}

}
