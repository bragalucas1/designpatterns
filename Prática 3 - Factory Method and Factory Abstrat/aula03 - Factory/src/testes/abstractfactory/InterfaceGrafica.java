package testes.abstractfactory;

import draw.interfaces.DrawableInterface;
import exibicao.Exibidor;
import fig.impl.Rectangle;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigFactoryInterface;
import fig.interfaces.FigListInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Classe que simula um subsistema onde figuras geom�tricas
 * s�o instanciadas, sem utilizar classes concretas.
 * Para isso, o padr�o Abstract Factory � aplicado.
 * @author  Vladimir Oliveira Di Iorio
 */
public class InterfaceGrafica extends JFrame {
	
	/**
	 * Armazena lista de figuras.
	 */
	private FigListInterface figDoc;

	/**
	 * F�brica usada para construir figuras.
	 */
	FigFactoryInterface factory;
		
	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	private Exibidor exibidor;

	/**
	 * Constr�i objeto recebendo f�brica abstrata.
	 * @param factory F�brica abstrata para construir formas geom�tricas.
	 */
	public InterfaceGrafica(FigFactoryInterface factory) {
		super("Teste");
		this.factory = factory;
		figDoc = constroiDados();
		exibidor = new Exibidor((DrawableInterface) figDoc);
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
	 * Constr�i uma lista de figuras.
	 * OBS: UTILIZA A F�BRICA ABSTRATA.
	 * @return Lista de figuras constru�da.
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
		figs.addFig(factory.createLine(150, 30, Color.GREEN, 20, 20));
		return figs;
	}

}
