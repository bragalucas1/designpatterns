package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.CircleInterface;

import java.awt.Graphics;

/**
 * Classe concreta que representa c�rculo que pode ser desenhado, usando composi��o e delega��o.
 * @author  Vladimir Oliveira Di Iorio
 */
public class CircleDrawable extends FigPosColorDrawable
implements CircleInterface, DrawableInterface {
	
	private CircleInterface circle;

	/**
	 * Constr�i c�rculo que pode ser desenhado.
	 * @param circle Interface que representa c�rculo.
	 */
	public CircleDrawable(CircleInterface circle) {
		super(circle.getPosX(), circle.getPosY(), circle.getAWTColor());
		this.circle = circle;
	}

	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawOval(getPosX() - getRadius(), getPosY() - getRadius(),
				getRadius() * 2, getRadius() * 2);
	}

	public int getRadius() {
		return circle.getRadius();
	}

	public void setRadius(int radius) {
		circle.setRadius(radius);
	}	
	
}
