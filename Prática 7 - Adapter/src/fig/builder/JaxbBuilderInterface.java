package fig.builder;

import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

/**
 * Interface para builders que serão usados
 * com o director deste mesmo pacote.
 * @see JaxbDirector
 * @author Vladimir Oliveira Di Iorio
 */
public interface JaxbBuilderInterface {
	
	/**
	 * Constrói círculo.
	 * @param circle Objeto Jaxb representando círculo.
	 */
	void buildCircle(CircleType circle);

	/**
	 * Constrói retângulo.
	 * @param rectangle Objeto Jaxb representando retângulo.
	 */
	void buildRectangle(RectangleType rectangle);

	/**
	 * Inicia um novo composite.
	 * @param composite Objeto Jaxb representando figura composta.
	 */
	void initComposite(CompositeType composite);
	
	/**
	 * Finaliza construção de um composite.
	 */
	void endComposite();

	/**
	 * Inicia construção de documento.
	 * Primeiro método a ser chamado pelo director.
	 * @param doc Objeto Jaxb representando documento com lista de figuras.
	 */
	void initDoc(FigDoc doc);
	
	/**
	 * Finaliza construção de documento.
	 * Último método a ser chamado pelo director.
	 */
	void endDoc();

	
	/**
	 * Constrói linha
	 * @param line
	 */
	void buildLine(LineType line);
	
}
