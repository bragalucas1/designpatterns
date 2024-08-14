package util;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

/**
 * Classe usada para encapsular operações de leitura de
 * arquivos XML e transformação para classes geradas com JAXB.
 * @author Vladimir Oliveira Di Iorio
 */
public class JaxbOperations {

	private Unmarshaller unmarshaller;
	
	private Marshaller marshaller;

	/**
	 * Construtor que recebe a URL de um contexto JAXB (pasta onde
	 * as classes foram geradas pelo JAXB) e a URL de um esquema XML
	 * para verificação do formato de arquivos. Todas as leituras
	 * feitas com este objeto deverão estar de acordo com o formato
	 * do esquema definido, para geração de classes do contexto
	 * especificado.
	 * @param contextURL URL de um contexto JAXB.
	 * @param schemaURL URL de um esquema XML.
	 * @throws JAXBException
	 */
	public JaxbOperations(String contextURL, String schemaURL)
	throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(contextURL,
        		this.getClass().getClassLoader());
        unmarshaller = context.createUnmarshaller();
        marshaller = context.createMarshaller();
        try {
            SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(schemaURL));
            unmarshaller.setSchema(schema);
            marshaller.setSchema(schema);
            ValidationEventHandler veh = 
                new ValidationEventHandler() {
	                public boolean handleEvent(ValidationEvent ve) {
	                    if (ve.getSeverity() != ValidationEvent.WARNING) {
	                        ValidationEventLocator vel = ve.getLocator();
	                        System.out.println("Linha/Coluna[" + vel.getLineNumber() +
	                            ":" + vel.getColumnNumber() +
	                            "]:" + ve.getMessage());
	                    }
	                    return true;
	                }
	            };
	            unmarshaller.setEventHandler(veh);
	            marshaller.setEventHandler(veh);
        } catch (org.xml.sax.SAXException se) {
            System.out.println("Não é possível validar o arquivo por causa dos erros abaixo.");
            se.printStackTrace();
        }
	}

	/**
	 * Lê um arquivo XML e constrói um objeto de classe gerada
	 * pelo JAXB. O conteúdo do arquivo deve seguir o formato
	 * especificado pelo esquema que foi fornecido no construtor,
	 * e o objeto gerado é composto por classes do contexto
	 * especificado também no construtor desta classe.
	 * @param xmlFileURL URL do arquivo XML.
	 * @return Objeto construído, representando o conteúdo do
	 * arquivo XML fornecido.
	 * @throws JAXBException
	 */
	public Object readObject(String xmlFileURL)
	throws JAXBException {
        Object poe = 
        	unmarshaller.unmarshal(new File(xmlFileURL));
		return poe;
	}
	
	/**
	 * Produz arquivo XML a partir de objeto na memória.
	 * @param xmlFileURL URL do arquivo XML a ser gerado.
	 * @param obj Objeto a partir do qual a representação XML será gerada.
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	public void writeObject(String xmlFileURL, Object obj)
	throws JAXBException, FileNotFoundException {
		FileOutputStream saida = new FileOutputStream(new File(xmlFileURL));
		marshaller.marshal(obj, saida);
	}

}
