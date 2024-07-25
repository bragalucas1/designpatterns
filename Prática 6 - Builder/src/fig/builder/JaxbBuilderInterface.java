package fig.builder;

import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

/**
 * Interface para builders que ser�o usados com o director deste mesmo pacote.
 * 
 * @see JaxbDirector
 * @author Vladimir Oliveira Di Iorio
 */
public interface JaxbBuilderInterface {

	/**
	 * Constr�i c�rculo.
	 * 
	 * @param circle Objeto Jaxb representando c�rculo.
	 */
	void buildCircle(CircleType circle);

	/**
	 * Constr�i ret�ngulo.
	 * 
	 * @param rectangle Objeto Jaxb representando ret�ngulo.
	 */
	void buildRectangle(RectangleType rectangle);

	/**
	 * Inicia um novo composite.
	 * 
	 * @param composite Objeto Jaxb representando figura composta.
	 */
	void initComposite(CompositeType composite);

	/**
	 * Finaliza constru��o de um composite.
	 */
	void endComposite();

	/**
	 * Inicia constru��o de documento. Primeiro m�todo a ser chamado pelo director.
	 * 
	 * @param doc Objeto Jaxb representando documento com lista de figuras.
	 */
	void initDoc(FigDoc doc);

	/**
	 * Finaliza constru��o de documento. �ltimo m�todo a ser chamado pelo director.
	 */
	void endDoc();

	void buildLine(LineType line);
}
