package fig.adapterJaxb;

import java.awt.Color;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;


/**
 * Fábrica concreta para criação de figuras.
 * @author Vladimir Oliveira Di Iorio
 */
public class FigFactory implements FigFactoryInterface {
	
	private fig.xmlclasses.ObjectFactory fac;
	
	public FigFactory() {
		fac = new fig.xmlclasses.ObjectFactory();
	}

	public FigListInterface createFigList() {
		return Adapter.adapt(fac.createFigListType());
	}

	public CircleInterface createCircle(
			int posX, int posY, Color color, int radius) {
		CircleInterface c = Adapter.adapt(fac.createCircleType());
		c.setPosX(posX);
		c.setPosY(posY);
		c.setAWTColor(color);
		c.setRadius(radius);
		return c;
	}
	
	public RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height) {
		RectangleInterface r = Adapter.adapt(fac.createRectangleType());
		r.setPosX(posX);
		r.setPosY(posY);
		r.setAWTColor(color);
		r.setWidth(width);
		r.setHeight(height);
		return r;
	}
	
	public LineInterface createLine(
			int posX, int posY, Color color, int posX2, int posY2) {
		LineInterface l = Adapter.adapt(fac.createLineType());
		l.setPosX(posX);
		l.setPosY(posY);
		l.setAWTColor(color);
		l.setPosX2(posX2);
		l.setPosY2(posY2);
		return l;
	}
	
	public CompositeInterface createComposite() {
		return Adapter.adapt(fac.createCompositeType());
	}
	
}
