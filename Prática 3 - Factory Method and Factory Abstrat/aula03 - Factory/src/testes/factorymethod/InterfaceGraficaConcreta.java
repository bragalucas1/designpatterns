package testes.factorymethod;

import java.awt.Color;
import draw.impl.CircleDrawable;
import draw.impl.CompositeDrawable;
import draw.impl.FigListDrawable;
import draw.impl.LineDrawable;
import draw.impl.RectangleDrawable;
import fig.impl.Circle;
import fig.impl.Composite;
import fig.impl.FigList;
import fig.impl.Line;
import fig.impl.Rectangle;
import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;

/**
 * Este teste demonstra o uso de um m�todo f�brica.
 * @author Vladimir Oliveira Di Iorio
 */
public class InterfaceGraficaConcreta extends InterfaceGrafica {
	
	/**
	 * @see testes.factorymethod.InterfaceGrafica#createFigList()
	 */
	public FigListInterface createFigList() {
		return new FigListDrawable(new FigList());
	}
	
	/**
	 * @see testes.factorymethod.InterfaceGrafica#createCircle(int, int, java.awt.Color, int)
	 */
	public CircleInterface createCircle(
			int posX, int posY, Color color, int radius) {
		return new CircleDrawable(new Circle(posX, posY, color, radius));
	}
	
	/**
	 * @see testes.factorymethod.InterfaceGrafica#createRectangle(int, int, java.awt.Color, int, int)
	 */
	public RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height) {
		return new RectangleDrawable(new Rectangle(posX, posY, color, width, height));
		
	}
	
	public LineInterface createLine(
			int posX, int posY, Color color, int posX2, int posY2) {
				return new LineDrawable(new Line(posX, posY, color, posX2, posY2));
	}
	
	/**
	 * @see testes.factorymethod.InterfaceGrafica#createComposite()
	 */
	public CompositeInterface createComposite() {
		return new CompositeDrawable(new Composite());
	}

	public static void main(String[] args) {
		InterfaceGraficaConcreta app = new InterfaceGraficaConcreta();
	}

}
