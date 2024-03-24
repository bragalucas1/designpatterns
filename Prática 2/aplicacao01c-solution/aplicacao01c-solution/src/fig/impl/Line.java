package fig.impl;

import java.awt.Color;

import fig.interfaces.LineInterface;

public class Line extends FigPosColor implements LineInterface {
	
	private int posX2, posY2;
	
	/**
	 * Constr�i uma linha.
	 * @param posX Posi��o horizontal do primeiro ponto.
	 * @param posY Posi��o vertical do primeiro ponto.
	 * @param color Cor da linha.
	 * @param posX2 Posi��o horizontal do segundo ponto.
	 * @param posY2 Posi��o vertical do segundo ponto.
	 */
	public Line(int posX, int posY, Color color, int posX2, int posY2) {
		super(posX, posY, color);
		this.posX2 = posX2;
		this.posY2 = posY2;
	}

	public int getPosX2() {
		return posX2;
	}

	public int getPosY2() {
		return posY2;
	}

	public void setPosX2(int posX2) {
		this.posX2 = posX2;
	}

	public void setPosY2(int posY2) {
		this.posY2 = posY2;
	}

}
