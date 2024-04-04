package testes;

import draw.impl.CircleDrawable;
import draw.impl.CompositeDrawable;
import draw.impl.FigListDrawable;
import draw.impl.LineDrawable;
import draw.impl.RectangleDrawable;
import exibicao.Exibidor;
import fig.impl.Circle;
import fig.impl.Composite;
import fig.impl.FigList;
import fig.impl.Line;
import fig.impl.Rectangle;
import fig.interfaces.FigListInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 * Este teste demonstra uso de exibidor de figuras com polimorfismo,
 * junto com classes concretas construídas com composição e delegação.
 * @author   Vladimir Oliveira Di Iorio
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
	 * Construtor, sem parâmetros.
	 */
	public Teste() {
		super("Teste");
		figDoc = constroiDados();
		exibidor = new Exibidor((FigListDrawable) figDoc);
		add(exibidor);
	    setSize (400, 300);
	    setVisible(true);
	}
	
	/**
	 * Constrói uma lista com um retângulo, um círculo e
	 * um objeto composto, formado por outro círculo e
	 * outro retângulo.
	 * @return Lista de figuras construída.
	 */
	private FigListInterface constroiDados() {
		FigListInterface figs = new FigList();
		figs.addFig(new RectangleDrawable(new Rectangle(60, 40, Color.BLUE, 50, 30)));
		figs.addFig(new CircleDrawable(new Circle(30, 30, Color.RED, 20)));
		Composite c = new Composite();
		c.addFig(new CircleDrawable(new Circle(150, 50, Color.ORANGE, 20)));
		c.addFig(new RectangleDrawable(new Rectangle(180, 60, Color.BLACK, 50, 30)));
		figs.addFig(new CompositeDrawable(c));
		figs.addFig(new LineDrawable(new Line(10, 10, Color.RED, 200, 200)));
		figs.addFig(new LineDrawable(new Line(200, 10, Color.GREEN, 10, 200)));
		return new FigListDrawable(figs);
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
