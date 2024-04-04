package draw;

import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;

import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;


/**
 * Exibidor de figuras usando Visitor.
 * @author  Vladimir Oliveira Di Iorio
 */
public class Exibidor extends JPanel {
	
	private FigDrawVisitor drawVisitor;
	private FigListInterface figList;

	public Exibidor(FigListInterface figList) {
		this.figList = figList;
		drawVisitor = new FigDrawVisitor();
	}

	public void paint(Graphics g) {
		super.paint(g);
		drawVisitor.setGraphics(g);
		figList.accept(drawVisitor);		
	}	
	
}
