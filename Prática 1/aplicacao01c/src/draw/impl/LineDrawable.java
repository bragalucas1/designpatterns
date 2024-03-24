package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.LineInterface;

import java.awt.Graphics;

public class LineDrawable extends FigPosColorDrawable
implements LineInterface, DrawableInterface {
    private LineInterface line;

    public LineDrawable(LineInterface line) {
        super(line.getPosX(), line.getPosY(), line.getAWTColor());
        this.line = line;
    }

    public void awtDraw(Graphics g) {
		g.setColor(getAWTColor());
		g.drawLine(getPosX(), getPosY(), getPosX2(), getPosY2());
	}	

    public void setPosX2(int posX2) { line.setPosX2(posX2); }

    public void setPosY2(int posY2) { line.setPosY2(posY2); }

    public int getPosX2() { return this.line.getPosX2(); }

    public int getPosY2() { return this.line.getPosY2(); }
}