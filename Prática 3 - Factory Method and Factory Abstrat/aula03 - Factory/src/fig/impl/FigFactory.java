package fig.impl;

import java.awt.Color;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;

/**
 * F�brica concreta para cria��o de figuras,
 * instanciando objetos com as classes do
 * pacote fig.impl.
 * @author Vladimir Oliveira Di Iorio
 */
public class FigFactory implements FigFactoryInterface {

	/**
	 * @see fig.interfaces.FigFactoryInterface#createFigList()
	 */
	public FigListInterface createFigList() {
		return new FigList();
	}

	/**
	 * @see fig.interfaces.FigFactoryInterface#createCircle(int, int, java.awt.Color, int)
	 */
	public CircleInterface createCircle(
			int posX, int posY, Color color, int radius) {
		return new Circle(posX, posY, color, radius);
	}
	
	/**
	 * @see fig.interfaces.FigFactoryInterface#createRectangle(int, int, java.awt.Color, int, int)
	 */
	public RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height) {
		return new Rectangle(posX, posY, color, width, height);
		
	}
	
	public LineInterface createLine(int posX, int posY, Color color, int posX2, int posY2) {
		return new Line(posX, posY, color, posX2, posY2);
	}
	/**
	 * @see fig.interfaces.FigFactoryInterface#createComposite()
	 */
	public CompositeInterface createComposite() {
		return new Composite();		
	}

}
