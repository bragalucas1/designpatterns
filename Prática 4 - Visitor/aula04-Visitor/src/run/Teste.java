package run;

import fig.impl.FigFactory;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import draw.Exibidor;

/**
 * Classe que simula um subsistema onde
 * figuras geométricas são instanciadas.
 * @author  Vladimir Oliveira Di Iorio
 */
public class Teste extends JFrame {
	
	/**
	 * Armazena lista de figuras.
	 */
	private FigListInterface figList;

	/**
	 * Fábrica usada para construir figuras.
	 */
	FigFactoryInterface factory;
		
	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	private Exibidor exibidor;

	/**
	 * Constrói objeto recebendo fábrica abstrata.
	 * @param factory Fábrica abstrata para construir formas geométricas.
	 */
	public Teste(FigFactoryInterface factory) {
		super("Teste");
		this.factory = factory;
		figList = constroiDados();
		exibidor = new Exibidor(figList);
		add(exibidor);
	    setSize (300, 300);
	    setVisible(true);
	    addWindowListener(
    		new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
    				System.exit( 0 );
    	        }
    		}
		    );
	}

	/**
	 * Constrói uma lista de figuras.
	 * OBS: UTILIZA A FÁBRICA ABSTRATA.
	 * @return Lista de figuras construída.
	 */
	private FigListInterface constroiDados() {
		FigListInterface figs = factory.createFigList();
		figs.addFig(factory.createRectangle(60, 40, Color.BLUE, 50, 30));
		figs.addFig(factory.createCircle(30, 30, Color.RED, 20));
		CompositeInterface c = factory.createComposite();
		c.addFig(factory.createCircle(150, 50, Color.ORANGE, 20));
		c.addFig(factory.createRectangle(180, 60, Color.BLACK, 50, 30));
		figs.addFig(c);
		figs.addFig(factory.createRectangle(30, 110, Color.MAGENTA, 50, 30));
		return figs;
	}
	
	public static void main(String args[]) {
		Teste app = new Teste(new FigFactory());
	    app.addWindowListener(
    		new WindowAdapter() {
    			public void windowClosing(WindowEvent e) {
    				System.exit( 0 );
    	        }
    		}
	    );
	}

}
