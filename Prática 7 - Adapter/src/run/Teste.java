package run;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import draw.Exibidor;
import fig.adapterJaxb.Adapter;
import fig.interfaces.CircleInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;
import fig.xmlclasses.FigDoc;
import util.JaxbOperations;

/**
 * Este teste demonstra o uso do padrão adapter,
 * para adaptar objetos lidos de um arquivo XML
 * para objetos satisfazendo as interfaces do
 * pacote fig.impl.
 * @author Vladimir Oliveira Di Iorio
 */
public class Teste extends JFrame {
	
	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	private Exibidor exibidor;

	/**
	 * Construtor, sem par�metros.
	 */
	public Teste() {
		super("Teste");

		JaxbOperations jop;
		
        try {
        	
        	// Define ambiente para o JAXB		
			jop = new JaxbOperations("fig.xmlclasses", "src/xsd/fig.xsd");
			
        	// Lê dados de um arquivo em XML, seguindo formato definido
			Object poe = jop.readObject("xmlfiles/fig01.xml");
	        		
            // Conversão explícita - poe deve ser um FigDoc,
            // classe criada pelo JAXB
            FigDoc figDoc = (FigDoc) poe;            

            // Cria uma "versão adaptada" para a lista de figuras lida
            Adapter adpater = new Adapter();
            FigListInterface figList = adpater.adapt(figDoc.getFigList());
            
            // Depois de ler o documento e criar uma adaptação,
            // acrescenta mais um grande círculo azul;
            // tem que ser usada a fábrica disponibilizada pelo pacote do adaptador
            FigFactoryInterface fac = new fig.adapterJaxb.FigFactory();
            CircleInterface c = fac.createCircle(200, 200, Color.BLUE, 150);
            figList.addFig(c);
            
            // escreve figura alterada, em um novo arquivo XML (para teste)
            jop.writeObject("xmlfiles/fig02.xml", figDoc);

            // exibe objeto criado
            exibidor = new Exibidor(figList);
            add(exibidor);
            setSize (400, 400);
            setVisible(true);
	    
        } catch( UnmarshalException ue ) {
            // The JAXB specification does not mandate how the JAXB provider
            // must behave when attempting to unmarshal invalid XML data.  In
            // those cases, the JAXB provider is allowed to terminate the 
            // call to unmarshal with an UnmarshalException.
            System.out.println( "Caught UnmarshalException" );
            System.out.println(ue);
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

	}
		
	public static void main(String[] args) {
		Teste app = new Teste();
	    app.addWindowListener(
    		new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
    				System.exit( 0 );
    	        }
    		}
	    );
	}

}
