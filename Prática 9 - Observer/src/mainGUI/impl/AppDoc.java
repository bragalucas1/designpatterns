package mainGUI.impl;

import fig.draw.HasFigList;
import fig.interfaces.FigListInterface;

public class AppDoc extends mainGUI.framework.AppDoc implements HasFigList {

	private FigListInterface figList;
	
	public FigListInterface getFigList() {
		return figList;
	}
	
	public void setFigList(FigListInterface figList) {
		this.figList = figList;
	}

}
