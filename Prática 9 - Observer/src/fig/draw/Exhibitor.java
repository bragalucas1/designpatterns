package fig.draw;

import java.awt.Graphics;
import javax.swing.JPanel;


public class Exhibitor extends JPanel {
	
	private FigDrawVisitor drawVisitor;
	private HasFigList hf;

	public Exhibitor(HasFigList hf) {
		drawVisitor = new FigDrawVisitor();
		this.hf = hf;
	}
	
	/**
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		super.paint(g);
		drawVisitor.setGraphics(g);
		hf.getFigList().accept(drawVisitor);
	}	
	
}
