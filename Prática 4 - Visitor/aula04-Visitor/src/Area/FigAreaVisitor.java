package Area;

import java.util.Iterator;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;

public class FigAreaVisitor implements VisitorInterface {
	private float area;

	public FigAreaVisitor() {
		area = 0;
	}

	public float getArea() {
		return area;
	}

	public void visit(CircleInterface circle) {
		area += (Math.PI * Math.pow(circle.getRadius(), 2));

	}

	public void visit(RectangleInterface rect) {
		area += rect.getWidth() * rect.getHeight();
	}

	public void visit(LineInterface line) {
		area += 0;
	}

	public void visit(CompositeInterface composite) {
		Iterator<FigInterface> iterator = composite.iterator();
		while (iterator.hasNext()) {
			FigInterface figure = iterator.next();
			figure.accept(this);
		}
	}

	public void visit(FigListInterface list) {
		Iterator<FigInterface> iterator = list.iterator();
		while (iterator.hasNext()) {
			FigInterface figure = iterator.next();
			figure.accept(this);
		}
	}
}
