package fig.impl;

import fig.interfaces.LineInterface;
import fig.interfaces.VisitorInterface;

import java.awt.Color;

/**
 * @author  Administrador
 */
public class Line extends FigPosColor implements LineInterface {

	private int posX2;
	private int posY2;

	public Line(int posX, int posY, Color color, int posX2, int posY2) {
		super(posX, posY, color);
		this.posX2 = posX2;
		this.posY2 = posY2;
	}

	public int getPosX2() {
		return posX2;
	}

	public void setPosX2(int posX2) {
		this.posX2 = posX2;
	}

	public int getPosY2() {
		return posY2;
	}

	public void setPosY2(int posY2) {
		this.posY2 = posY2;
	}
	
	public void accept(VisitorInterface visitor) {
		// insert code here...
	}

}
