package draw.impl;

import java.awt.Graphics;

import draw.interfaces.DrawableInterface;
import fig.interfaces.LineInterface;

public class LineDrawable extends FigPosColorDrawable
implements LineInterface, DrawableInterface {

	public LineDrawable(LineInterface line) {
		super(line);
	}

	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawLine(getPosX(), getPosY(), getPosX2(), getPosY2());
	}

	public int getPosX2() {
		return ((LineInterface) fig).getPosX2();
	}

	public int getPosY2() {
		return ((LineInterface) fig).getPosY2();
	}

	public void setPosX2(int posX2) {
		((LineInterface) fig).setPosX2(posX2);
	}

	public void setPosY2(int posY2) {
		((LineInterface) fig).setPosY2(posY2);
	}

}
