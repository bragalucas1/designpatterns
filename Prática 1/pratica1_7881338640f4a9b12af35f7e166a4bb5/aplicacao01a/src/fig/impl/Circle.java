package fig.impl;

import fig.interfaces.CircleInterface;
import java.awt.Color;

public class Circle extends FigPosColor
implements CircleInterface {
	private int radius;
	
	public Circle(int posX, int posY, Color color, int radius) {
		super(posX, posY, color);
		this.radius = radius;
	}
	
	public int getRadius() { return radius; }
	
	public void setRadius(int radius) { this.radius = radius; }
}
