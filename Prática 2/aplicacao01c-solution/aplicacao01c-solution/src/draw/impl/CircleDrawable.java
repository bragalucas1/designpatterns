package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.CircleInterface;

import java.awt.Graphics;

/**
 * Classe concreta que representa círculo que pode ser desenhado,
 * usando composição e delegação.
 * @author  Vladimir Oliveira Di Iorio
 */
public class CircleDrawable extends FigPosColorDrawable
implements CircleInterface, DrawableInterface {

	/**
	 * Constrói círculo que pode ser desenhado.
	 * @param circle Interface que representa círculo.
	 */
	public CircleDrawable(CircleInterface circle) {
		super(circle);
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
		return ((CircleInterface) fig).getRadius();
	}

	public void setRadius(int radius) {
		((CircleInterface) fig).setRadius(radius);
	}	
	
}
