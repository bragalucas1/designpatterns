package draw;


import java.awt.Graphics;

import fig.interfaces.*;

public class FigDrawVisitor implements VisitorInterface {
	
	private Graphics g;
	
	public void setGraphics(Graphics g) {
		this.g = g;
	}
	
	public void visit(CircleInterface circle) {
		g.setColor(circle.getAWTColor());
		g.drawOval(circle.getPosX() - circle.getRadius(),
				circle.getPosY() - circle.getRadius(),
				circle.getRadius() * 2, circle.getRadius() * 2);

	}
	
	public void visit(RectangleInterface rect) {
		g.setColor(rect.getAWTColor());
		g.drawRect(rect.getPosX(), rect.getPosY(),
				rect.getWidth(), rect.getHeight());

	}
	
	public void visit(LineInterface line) {
		g.setColor(line.getAWTColor());
		g.drawLine(line.getPosX(), line.getPosY(),
				line.getPosX2(), line.getPosY2());

	}
	
	public void visit(CompositeInterface composite) {
		for (FigInterface fig : composite) {
			fig.accept(this);
		}		
	}
	
	public void visit(FigListInterface list) {
		for (FigInterface fig : list) {
			fig.accept(this);
		}
	}
	
}
