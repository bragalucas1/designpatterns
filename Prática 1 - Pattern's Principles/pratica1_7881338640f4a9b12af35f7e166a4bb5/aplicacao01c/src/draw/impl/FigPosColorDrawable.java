package draw.impl;

import java.awt.Color;
import fig.interfaces.FigPosColorInterface;

public class FigPosColorDrawable 
implements FigPosColorInterface {
	private int posX;
	private int posY;
	private Color color;

	public FigPosColorDrawable(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}

	public void setAWTColor(Color color) {
		this.color = color;
	}

    public Color getAWTColor() {
		return this.color;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}
}
