package fig.impl;

import fig.interfaces.CircleInterface;
import java.awt.Color;

/**
 * Classe concreta para representar círculos.
 * @author   Vladimir Oliveira Di Iorio
 */
public class Circle extends FigPosColor
implements CircleInterface {
	
	/**
	 * Raio do círculo.
	 */
	private int radius;
	
	/**
	 * Constrói um círculo.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param radius Raio do círculo.
	 */
	public Circle(int posX, int posY, Color color, int radius) {
		super(posX, posY, color);
		this.radius = radius;
	}
	
	/**
	 * @see fig.interfaces.CircleInterface#getRadius()
	 */
	public int getRadius() { return radius; }
	
	/**
	 * @see fig.interfaces.CircleInterface#setRadius(int)
	 */
	public void setRadius(int radius) { this.radius = radius; }
	
}
