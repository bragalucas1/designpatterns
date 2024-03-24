package draw.impl;

import java.awt.Color;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;

/**
 * Fábrica concreta para criação de figuras,
 * instanciando objetos com as classes do pacote draw.impl.
 * @author  Vladimir Oliveira Di Iorio
 */
public class FigDrawableFactory_FEIA
implements FigFactoryInterface {

	/**
	 * @see fig.interfaces.FigFactoryInterface#createFigList()
	 */
	public FigListInterface createFigList() {
		return new FigListDrawable(new fig.impl.FigList());
	}
	
	/**
	 * @see fig.interfaces.FigFactoryInterface#createCircle(int, int, java.awt.Color, int)
	 */
	public CircleInterface createCircle(
			int posX, int posY, Color color, int radius) {
		return new CircleDrawable(new fig.impl.Circle(posX, posY, color, radius));
	}
	
	/**
	 * @see fig.interfaces.FigFactoryInterface#createRectangle(int, int, java.awt.Color, int, int)
	 */
	public RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height) {
		return new RectangleDrawable(new fig.impl.Rectangle(posX, posY, color, width, height));
		
	}

	/**
	 * @see fig.interfaces.FigFactoryInterface#createComposite()
	 */
	public CompositeInterface createComposite() {
		return new CompositeDrawable(new fig.impl.Composite());
	}
	
}
