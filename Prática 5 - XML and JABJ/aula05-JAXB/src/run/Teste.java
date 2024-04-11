package run;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.FigListType;
import fig.xmlclasses.FigType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

/**
 * Este teste demonstra o uso de JAXB para imprimir informa��es de objetos lidos
 * de um arquivo XML.
 * 
 * @author Vladimir Oliveira Di Iorio
 */
public class Teste {

	private static void setSchemaToUnmarshaller(Unmarshaller u, String schemaName) throws JAXBException {
		// O que est� dentro do bloco try-catch abaixo est� relacionado
		// apenas � valida��o de arquivo XML contendo um esquema.
		// Um esquema � associado ao unmarshaller.
		try {

			// Obt�m f�brica de esquemas
			SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);

			// Cria esquema na mem�ria, dado arquivo contendo esquema
			Schema schema = sf.newSchema(new File(schemaName));

			// associa esquema carregado ao unmarshaller
			u.setSchema(schema);

			// define comportamento, em caso de erros encontrados na valida��o
			u.setEventHandler(new ValidationEventHandler() {
				// Este m�todo pode verificar o erro ocorrido e indicar ao
				// sistema qual comportamento ter�, nos casos de erro.
				// O comportamento � definido pelo valor retornado pela fun��o.
				// Se retornar true, indica que o processo deve continuar
				// normalmente; se retornar false, exce��o ser� lan�ada.
				public boolean handleEvent(ValidationEvent ve) {
					// ignora os erros (retorna true), mas imprime msgs
					if (ve.getSeverity() != ValidationEvent.WARNING) {
						ValidationEventLocator vel = ve.getLocator();
						System.out.println("Linha/Coluna[" + vel.getLineNumber() + ":" + vel.getColumnNumber() + "]:"
								+ ve.getMessage());
					}
					return true;
				}
			});
		} catch (org.xml.sax.SAXException se) {
			System.out.println("N�o � poss�vel validar o arquivo por causa dos erros abaixo.");
			se.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			// Cria contexto JAXB.
			// Deve ser usado comO par�metro o nome do pacote criado,
			// quando o XJC foi executado.
			JAXBContext jc = JAXBContext.newInstance("fig.xmlclasses");

			// Cria um Unmarshaller, que permite transformar
			// arquivo XML em objetos Java.
			Unmarshaller u = jc.createUnmarshaller();

			setSchemaToUnmarshaller(u, "src/xsd/fig.xsd");
			;

			// l� arquivo XML com o unmarshaller
			Object poe = u.unmarshal(new File("input/fig01.xml"));

			// imprime no console, usando marshaller
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(poe, System.out);

			// convers�o expl�cita - poe deve ser um FigDoc,
			// classe criada pelo JAXB
			FigDoc figDoc = (FigDoc) poe;
			printFigList(figDoc.getFigList(), 0);

		} catch (UnmarshalException ue) {
			// The JAXB specification does not mandate how the JAXB provider
			// must behave when attempting to unmarshal invalid XML data. In
			// those cases, the JAXB provider is allowed to terminate the
			// call to unmarshal with an UnmarshalException.
			System.out.println("Caught UnmarshalException");
			System.out.println(ue);
		} catch (JAXBException je) {
			je.printStackTrace();
		}

	}

	private static void printFigList(FigListType figlisType, int indent) {
		List<JAXBElement<? extends FigType>> list = figlisType.getFigElement();
		for (JAXBElement<? extends FigType> jaxbElement : list) {
			for (int i = 0; i < indent; ++i) {
				System.out.print(" ");
			}
			FigType fig = jaxbElement.getValue();
			if (fig instanceof CircleType) {
				CircleType c = (CircleType) fig;
				System.out.println("Circle de cor: " + c.getColor() + " e raio: " + c.getRadius());
			} else if (fig instanceof RectangleType) {
				RectangleType r = (RectangleType) fig;
				System.out.println("Rectangle: Width=" + r.getWidth() + ", Height=" + r.getHeight());
			} else if (fig instanceof LineType) {
				LineType l = (LineType) fig;
				System.out.println("Line: Start=(" + l.getPosX() + "," + l.getPosY() + "), End=(" + l.getPosX2() + ","
						+ l.getPosY2() + ")");
			} else if (fig instanceof CompositeType) {
				CompositeType c = (CompositeType) fig;
				System.out.println("Composite");
				printFigList(c.getFigList(), indent + 4);
			}
		}
	}

}
