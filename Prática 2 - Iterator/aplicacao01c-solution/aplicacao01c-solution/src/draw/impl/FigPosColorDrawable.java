package draw.impl;

import java.awt.Color;

import fig.interfaces.FigPosColorInterface;

public class FigPosColorDrawable implements FigPosColorInterface {

	protected FigPosColorInterface fig;
	
	public FigPosColorDrawable(FigPosColorInterface fig) {
		this.fig = fig;
	}
	
	public Color getAWTColor() {
		return fig.getAWTColor();
	}

	public int getPosX() {
		return fig.getPosX();
	}

	public int getPosY() {
		return fig.getPosY();
	}

	public void setAWTColor(Color color) {
		fig.setAWTColor(color);
	}

	public void setPosX(int posX) {
		fig.setPosX(posX);
	}

	public void setPosY(int posY) {
		fig.setPosY(posY);
	}


}
