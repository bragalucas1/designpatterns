package fig.impl;
import fig.interfaces.LineInterface;
import java.awt.Color;

public class Line extends FigPosColor
implements LineInterface {
	
	private int posX2;
	private int posY2;
	
	/**
	 * Constr�i uma linha.
	 * @param posX2 Posi��o horizontal.
	 * @param posY2 Posi��o vertical.
	 * @param color Cor da borda.
	 */
	public Line(int posX, int posY, int posX2, int posY2, Color color) {
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
