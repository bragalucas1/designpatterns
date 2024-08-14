package fig.adapterJaxb;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigListType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

public class Adapter {

	public CircleInterface adapt(CircleType circleType) {
		return new Circle(circleType);
	}

	public RectangleInterface adapt(RectangleType rectangleType) {
		return new Rectangle(rectangleType);
	}

	public FigListInterface adapt(FigListType figListType) {
		return new FigList(figListType);
	}

	public CompositeInterface adapt(CompositeType compositeType) {
		return new Composite(compositeType);
	}

	public LineInterface adapt(LineType lineType) {
		return new Line(lineType);
	}
}
