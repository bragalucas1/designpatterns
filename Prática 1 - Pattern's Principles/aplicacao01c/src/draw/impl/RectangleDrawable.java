package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.RectangleInterface;
import java.awt.Graphics;

/**
 * Classe concreta que representa ret�ngulo que pode ser desenhado, usando composi��o e delega��o.
 * @author  Vladimir Oliveira Di Iorio
 */
public class RectangleDrawable extends FigPosColorDrawable
implements RectangleInterface, DrawableInterface {

	private RectangleInterface rect;
	
	/**
	 * Constr�i ret�ngulo que pode ser desenhado.
	 * @param r Interface que representa ret�ngulo.
	 */
	public RectangleDrawable(RectangleInterface rect) {
		super(rect.getPosX(), rect.getPosY(), rect.getAWTColor());
		this.rect = rect;
	}
	
	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
	}

	public int getHeight() {
		return rect.getHeight();
	}

	public int getWidth() {
		return rect.getWidth();
	}

	public void setHeight(int height) {
		rect.setHeight(height);
	}

	public void setWidth(int width) {
		rect.setWidth(width);
	}
	
}
