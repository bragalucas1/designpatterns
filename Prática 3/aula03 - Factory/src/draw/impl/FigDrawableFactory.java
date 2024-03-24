package draw.impl;

import java.awt.Color;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.RectangleInterface;

/**
 * Fábrica concreta para criação de figuras,
 * instanciando objetos com as classes do pacote draw.impl.
 * @author  Vladimir Oliveira Di Iorio
 */
public class FigDrawableFactory
implements FigFactoryInterface {

	/**
	 * Referência para uma fábrica abstrata auxiliar.
	 */
	private fig.interfaces.FigFactoryInterface factory;

	/**
	 * Constrói fábrica recebendo outra fábrica.
	 * @param factory Fábrica auxiliar.
	 */
	public FigDrawableFactory(fig.interfaces.FigFactoryInterface factory) {
		this.factory = factory;
	}

	/**
	 * @see fig.interfaces.FigFactoryInterface#createFigList()
	 */
	public FigListInterface createFigList() {
		return new FigListDrawable(factory.createFigList());
	}
	
	/**
	 * @see fig.interfaces.FigFactoryInterface#createCircle(int, int, java.awt.Color, int)
	 */
	public CircleInterface createCircle(
			int posX, int posY, Color color, int radius) {
		return new CircleDrawable(factory.createCircle(posX, posY, color, radius));
	}
	
	/**
	 * @see fig.interfaces.FigFactoryInterface#createRectangle(int, int, java.awt.Color, int, int)
	 */
	public RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height) {
		return new RectangleDrawable(factory.createRectangle(posX, posY, color, width, height));
		
	}

	/**
	 * @see fig.interfaces.FigFactoryInterface#createComposite()
	 */
	public CompositeInterface createComposite() {
		return new CompositeDrawable(factory.createComposite());
	}

}
