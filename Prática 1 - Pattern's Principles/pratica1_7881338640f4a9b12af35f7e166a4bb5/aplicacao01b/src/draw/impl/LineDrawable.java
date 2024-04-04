package draw.impl;

import java.awt.Color;
import java.awt.Graphics;
import draw.interfaces.DrawableInterface;
import fig.impl.Line;
import fig.interfaces.LineInterface;

public class LineDrawable
extends Line
implements DrawableInterface {
	public LineDrawable(int posX, int posY, Color color, int posX2, int posY2) {
		super(posX, posY, color, posX2, posY2);
	}
	
	public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawLine(getPosX(), getPosY(), getPosX2(), getPosY2());
	}	
}