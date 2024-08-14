package fig.builder;

import java.util.List;

import javax.xml.bind.JAXBElement;

import fig.xmlclasses.CircleType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.FigListType;
import fig.xmlclasses.FigType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;
import fig.xmlclasses.CompositeType;;

/**
 * Implementação de um director que define
 * a tradução de um FigDoc (objeto JAXB)
 * para qualquer outro formato.
 * Deve ser usado com builders que satisfaçam
 * a interface FigBuilderInterface.
 * @see JaxbBuilderInterface
 * @author Vladimir Oliveira Di Iorio
 */
public class JaxbDirector {

	/**
	 * Objeto a ser traduzido.
	 */
	private FigDoc figDoc;
	
	/**
	 * Builder que será usado na tradução.
	 */
	private JaxbBuilderInterface builder;
	
	/**
	 * Construtor, que recebe objeto a ser traduzido.
	 * @param figDoc Objeto a ser traduzido.
	 */
	public JaxbDirector(FigDoc figDoc) {
		this.figDoc = figDoc;		
	}
	
	/**
	 * Método auxiliar, chamado recursivamente, para percorrer
	 * listas de figuras.
	 * @param figList Lista de figuras (formato JAXB) que devem ser
	 * traduzidas e inseridas na lista de figuras atual.
	 */
	private void construct(FigListType figList) {
		List<JAXBElement<? extends FigType>> figElement =
			figList.getFigElement();
		for (JAXBElement<? extends FigType> jaxbElement : figElement) {
			FigType fig = jaxbElement.getValue();
			if (fig instanceof CircleType) {
				builder.buildCircle((CircleType) fig);
			} else if (fig instanceof RectangleType) {
				builder.buildRectangle((RectangleType) fig);
			} else if (fig instanceof LineType) {
				builder.buildLine((LineType) fig);
			} else if (fig instanceof CompositeType) {
				CompositeType c = (CompositeType) fig;
				builder.initComposite(c);
				// chamada recursiva...
				construct(c.getFigList());
				builder.endComposite();
			}
		}
	}
	
	/**
	 * Executa tradução, usando um builder.
	 * @param builder Objeto que satisfaz a interface para builders
	 * definida neste mesmo pacote.
	 */
	public void construct(JaxbBuilderInterface builder) {
		this.builder = builder;
		builder.initDoc(figDoc);
		FigListType figList = figDoc.getFigList();
		construct(figList);
		builder.endDoc();
	}
	
	
}
