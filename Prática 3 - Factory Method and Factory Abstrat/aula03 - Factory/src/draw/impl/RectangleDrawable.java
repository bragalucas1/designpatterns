package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.RectangleInterface;
import java.awt.Graphics;

/**
 * Classe concreta que representa retângulo que pode ser desenhado,
 * usando composição e delegação.
 * @author  Vladimir Oliveira Di Iorio
 */
public class RectangleDrawable
extends FigPosColorDrawable
implements RectangleInterface, DrawableInterface {
	
	/**
	 * Constrói retângulo que pode ser desenhado.
	 * @param r Interface que representa retângulo.
	 */
	public RectangleDrawable(RectangleInterface rect) {
		super(rect);
	}
	
	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawRect(getPosX(), getPosY(), getWidth(), getHeight());
	}

	public int getHeight() {
		return ((RectangleInterface) fig).getHeight();
	}

	public int getWidth() {
		return ((RectangleInterface) fig).getWidth();
	}

	public void setHeight(int height) {
		((RectangleInterface) fig).setHeight(height);
	}
	
	public void setWidth(int width) {
		((RectangleInterface) fig).setWidth(width);
	}
	
}
