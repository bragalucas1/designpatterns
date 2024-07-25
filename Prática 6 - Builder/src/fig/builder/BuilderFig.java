package fig.builder;

import java.awt.Color;
import java.util.Stack;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

/**
 * Implementa��o de builder para traduzir objetos gerados pelo JAXB em objetos
 * criados por alguma f�brica de fig.interfaces.
 * 
 * @author Vladimir Oliveira Di Iorio
 */
public class BuilderFig implements JaxbBuilderInterface {

	/**
	 * F�brica usada para criar os objetos que v�o formar o resultado da tradu��o.
	 */
	private FigFactoryInterface factory;

	/**
	 * Resultado da tradu��o.
	 */
	private FigListInterface figList;

	/**
	 * Pilha para armazenar a seq��ncia de listas onde as figuras ser�o inseridas. A
	 * lista que estiver no topo da pilha ser� a lista atual.
	 */
	private Stack<FigListInterface> figStack;

	/**
	 * Construtor que recebe uma f�brica para constru��o de objetos satisfazendo as
	 * interfaces de fig.interfaces.
	 * 
	 * @param factory F�brica apropriada.
	 */
	public BuilderFig(FigFactoryInterface factory) {
		this.factory = factory;
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#initDoc(FigDoc)
	 */
	public void initDoc(FigDoc doc) {
		figList = factory.createFigList();
		figStack = new Stack<FigListInterface>();
		figStack.push(figList);
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#endDoc()
	 */
	public void endDoc() {
		// ... nada a fazer
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#initComposite(CompositeType)
	 */
	public void initComposite(CompositeType composite) {
		FigListInterface list = figStack.peek();
		CompositeInterface c = factory.createComposite();
		list.addFig(c);
		figStack.push(c);
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#endComposite()
	 */
	public void endComposite() {
		figStack.pop();
	}

	/**
	 * M�todo auxiliar para criar objeto Color, a partir de defini��o textual em
	 * base hexadecimal.
	 * 
	 * @param color Texto representando cor RGB, em hexadecimal.
	 * @return Objeto Color correspondente.
	 */
	private Color createColor(String color) {
		String s1 = color.substring(0, 2);
		String s2 = color.substring(2, 4);
		String s3 = color.substring(4, 6);
		int c1 = Integer.parseInt(s1, 16);
		int c2 = Integer.parseInt(s2, 16);
		int c3 = Integer.parseInt(s3, 16);
		return new Color(c1, c2, c3);
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#buildCircle(CircleType circle)
	 */
	public void buildCircle(CircleType circle) {
		FigListInterface list = figStack.peek();
		CircleInterface c = factory.createCircle(circle.getPosX(), circle.getPosY(), createColor(circle.getColor()),
				circle.getRadius());
		list.addFig(c);
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#buildRectangle(RectangleType rectangle)
	 */
	public void buildRectangle(RectangleType rectangle) {
		FigListInterface list = figStack.peek();
		RectangleInterface r = factory.createRectangle(rectangle.getPosX(), rectangle.getPosY(),
				createColor(rectangle.getColor()), rectangle.getWidth(), rectangle.getHeight());
		list.addFig(r);
	}

	/**
	 * Obt�m o resultado da tradu��o.
	 * 
	 * @return Resultado da tradu��o.
	 */
	public FigListInterface getFigList() {
		return figList;
	}

	public void buildLine(LineType line) {
		FigListInterface list = figStack.peek();
		LineInterface x = factory.createLine(line.getPosX(), line.getPosY(), createColor(line.getColor()),
				line.getPosX2(), line.getPosY2());
		list.addFig(x);
	}
}
