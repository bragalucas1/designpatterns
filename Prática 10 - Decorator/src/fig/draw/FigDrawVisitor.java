package fig.draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import fig.bounds.BoundingBoxInterface;
import fig.bounds.FigBoundsVisitor;
import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.DecoratorInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;

public class FigDrawVisitor implements VisitorInterface {
	private Graphics g;
	private static float dash[] = { 5, 5 };
	private BasicStroke dashStroke = new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1, dash, 0);

	public void setGraphics(Graphics g) {
		this.g = g;
	}

	public void visit(CircleInterface circle) {
		g.setColor(circle.getAWTColor());
		g.drawOval(circle.getPosX() - circle.getRadius(), circle.getPosY() - circle.getRadius(), circle.getRadius() * 2,
				circle.getRadius() * 2);

	}

	public void visit(RectangleInterface rect) {
		g.setColor(rect.getAWTColor());
		g.drawRect(rect.getPosX(), rect.getPosY(), rect.getWidth(), rect.getHeight());

	}

	public void visit(LineInterface line) {
		g.setColor(line.getAWTColor());
		g.drawLine(line.getPosX(), line.getPosY(), line.getPosX2(), line.getPosY2());

	}

	public void visit(CompositeInterface composite) {
		for (FigInterface fig : composite) {
			fig.accept(this);
		}
	}

	public void visit(FigListInterface list) {
		for (FigInterface fig : list) {
			fig.accept(this);
		}
	}

	public void visit(DecoratorInterface border) {
		// Por enquanto, vamos assumir que o Decorator ser� sempre uma borda.

		// A figura dentro da borda pode ser qualquer coisa,
		// incluindo uma figura composta ou outra figura com borda.
		// Ela � desenhada pela chamada a seguir:
		border.getFig().accept(this);
		// cor da borda
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		// guarda o stroke antigo, para restaurá-lo depois
		Stroke s = g2.getStroke();
		// modifica o stroke, para representar tracejamento
		g2.setStroke(dashStroke);
		// ------------------------------------------------------
		// Calcula o bounding box da figura interna
		FigBoundsVisitor boundsVisitor = new FigBoundsVisitor();
		border.getFig().accept(boundsVisitor); // Visita a figura interna
		BoundingBoxInterface box = boundsVisitor.getBox();

		// Adiciona uma "folga" para bordas
		int padding = 5; // Ajuste conforme necessário
		int x = box.getPosX() - padding;
		int y = box.getPosY() - padding;
		int width = box.getWidth() + 2 * padding;
		int height = box.getHeight() + 2 * padding;

		// Desenha o retângulo ao redor da figura
		g2.drawRect(x, y, width, height);
		// ------------------------------------------------------
		// restaura o stroke antigo
		g2.setStroke(s);
		border.getFig().accept(this); // Desenha a figura após a borda
	}

}
