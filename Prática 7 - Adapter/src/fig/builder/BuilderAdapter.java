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
 * Implementação de builder para traduzir objetos gerados pelo JAXB
 * em objetos criados por alguma fábrica de fig.interfaces.
 * @author Vladimir Oliveira Di Iorio
 */
public class BuilderAdapter implements JaxbBuilderInterface {

	/**
	 * Fábrica usada para criar os objetos que vão formar
	 * o resultado da tradução.
	 */
	private FigFactoryInterface factory;
	
	/**
	 * Resultado da tradução.
	 */
	private FigListInterface figList;
	
	/**
	 * Pilha para armazenar a seqüência de listas
	 * onde as figuras serão inseridas. A lista que
	 * estiver no topo da pilha será a lista atual.
	 */
	private Stack<FigListInterface> figStack;

	/**
	 * Construtor que recebe uma fábrica para construção
	 * de objetos satisfazendo as interfaces de fig.interfaces.
	 * @param factory Fábrica apropriada.
	 */
	public BuilderAdapter(FigFactoryInterface factory) {
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
	 * Método auxiliar para criar objeto Color,
	 * a partir de definição textual em base hexadecimal.
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
		CircleInterface c = factory.createCircle(circle.getPosX(), circle.getPosY(),
				createColor(circle.getColor()), circle.getRadius());
		list.addFig(c);
	}

	/**
	 * @see fig.builder.JaxbBuilderInterface#buildRectangle(RectangleType rectangle)
	 */
	public void buildRectangle(RectangleType rectangle) {
		FigListInterface list = figStack.peek();
		RectangleInterface r = factory.createRectangle(
				rectangle.getPosX(), rectangle.getPosY(),
				createColor(rectangle.getColor()),
				rectangle.getWidth(), rectangle.getHeight());
		list.addFig(r);
	}

	
	public void buildLine(LineType line) {
		FigListInterface list = figStack.peek();
		LineInterface l = factory.createLine(
				line.getPosX(), line.getPosY(),
				createColor(line.getColor()),
				line.getPosX2(), line.getPosY2());
		list.addFig(l);
	}

	
	/**
	 * Obtém o resultado da tradução.
	 * @return Resultado da tradução.
	 */
	public FigListInterface getFigList() {
		return figList;
	}

}
