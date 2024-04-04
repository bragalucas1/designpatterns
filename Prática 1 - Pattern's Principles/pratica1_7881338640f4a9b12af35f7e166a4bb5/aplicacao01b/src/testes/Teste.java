package testes;

import draw.impl.CircleDrawable;
import draw.impl.CompositeDrawable;
import draw.impl.FigListDrawable;
import draw.impl.RectangleDrawable;
import draw.impl.LineDrawable;
import draw.interfaces.DrawableInterface;
import exibicao.Exibidor;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigListInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;


/**
 * Este teste demonstra uso de exibidor de figuras com polimorfismo,
 * junto com classes concretas constru�das com heran�a.
 * @author  Vladimir Oliveira Di Iorio
 */
public class Teste extends JFrame {
	
	/**
	 * Documento com figuras.
	 */
	private FigListInterface figDoc;
	
	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	private Exibidor exibidor;

	/**
	 * Construtor, sem par�metros.
	 */
	public Teste() {
		super("Teste");
		figDoc = constroiDados();
		exibidor = new Exibidor((DrawableInterface) figDoc);
		add(exibidor);
	    setSize (400, 300);
	    setVisible(true);
	}
	
	/**
	 * Constr�i uma lista com um ret�ngulo, um c�rculo e
	 * um objeto composto, formado por outro c�rculo e
	 * outro ret�ngulo.
	 * @return Lista de figuras constru�da.
	 */
	private FigListInterface constroiDados() {
		FigListInterface figs = new FigListDrawable();
		figs.addFig(new RectangleDrawable(60, 40, Color.BLUE, 50, 30));
		figs.addFig(new CircleDrawable(30, 30, Color.RED, 20));
		figs.addFig(new LineDrawable(210, 10, Color.BLUE, 250, 10));
		CompositeInterface c = new CompositeDrawable();
		c.addFig(new CircleDrawable(150, 50, Color.ORANGE, 20));
		c.addFig(new RectangleDrawable(180, 60, Color.BLACK, 50, 30));
		c.addFig(new LineDrawable(300, 5, Color.RED, 350, 6));
		figs.addFig(c);
		return figs;
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
