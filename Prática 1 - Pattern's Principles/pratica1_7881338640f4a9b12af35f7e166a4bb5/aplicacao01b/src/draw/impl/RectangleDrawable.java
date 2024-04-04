package draw.impl;

import java.awt.Color;
import java.awt.Graphics;
import draw.interfaces.DrawableInterface;
import fig.impl.Rectangle;
import fig.interfaces.RectangleInterface;

/**
 * Classe concreta que representa retângulo
 * que pode ser desenhado, usando herança.
 * @author Vladimir Oliveira Di Iorio
 */
public class RectangleDrawable
extends Rectangle
implements DrawableInterface {

	/**
	 * Constrói um retângulo que pode ser desenhado.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param width Largura.
	 * @param height Altura.
	 */
	public RectangleDrawable(int posX, int posY, Color color, int width, int height) {
		super(posX, posY, color, width, height);
	}

	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
	}
	
}
