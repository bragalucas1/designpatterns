package run;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import draw.Exibidor;
import fig.builder.BuilderFig;
import fig.builder.BuilderSvg;
import fig.builder.JaxbDirector;
import fig.impl.FigFactory;
import fig.interfaces.FigListInterface;
import fig.xmlclasses.FigDoc;

/**
 * Este teste demonstra o uso do padr�o builder, para traduzir objetos lidos de
 * um arquivo XML para objetos satisfazendo as interfaces do pacote fig.impl.
 * 
 * @author Vladimir Oliveira Di Iorio
 */
public class Teste extends JFrame {

	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	private Exibidor exibidor;

	private static void setSchemaToUnmarshaller(Unmarshaller u, String schemaName) throws JAXBException {
		// O que est� dentro do bloco try-catch abaixo est� relacionado
		// apenas � valida��o de arquivo XML com um esquema.
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

	/**
	 * Construtor, sem par�metros.
	 */
	public Teste() {
		super("Teste");

		try {
			// Cria contexto JAXB.
			// Deve ser usado com par�metro o nome do pacote criado,
			// quando o JAXB foi executado.
			JAXBContext jc = JAXBContext.newInstance("fig.xmlclasses", this.getClass().getClassLoader());

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

			// ********* TRADUCAO USANDO BUILDER **************//

			// cria director para traduzir figDoc (objeto JAXB)
			JaxbDirector director = new JaxbDirector(figDoc);

			// cria builder, passando f�brica como par�metro
			BuilderFig appBuilder = new BuilderFig(new FigFactory());

			// executa tradu��o, usando o builder criado
			director.construct(appBuilder);

			// obt�m resultado - ATEN��O: RESULTADO NO BUILDER!
			FigListInterface list = appBuilder.getFigList();

			BuilderSvg svgBuilder = new BuilderSvg("teste");
			director.construct(svgBuilder);

			// ***********************************************//

			// exibe objeto criado com a tradu��o
			exibidor = new Exibidor(list);
			add(exibidor);
			setSize(400, 400);
			setVisible(true);

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

	public static void main(String[] args) {
		Teste app = new Teste();
		app.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}
