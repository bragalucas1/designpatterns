package fig.adapterJaxb;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigListType;
import fig.xmlclasses.FigType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

public class Adapter {
	
	private Adapter() { }
	
	public static CircleInterface adapt(CircleType circleType) {
		return new Circle(circleType);
	}
	
	public static RectangleInterface adapt(RectangleType rectangleType) {
		return new Rectangle(rectangleType);
	}
	
	public static FigListInterface adapt(FigListType figListType) {
		return new FigList(figListType);
	}
	
	public static CompositeInterface adapt(CompositeType compositeType) {
		return new Composite(compositeType);
	}
	
	public static FigInterface adapt(FigType fig) {
		if (fig instanceof CircleType) {
			return adapt((CircleType) fig);
		} else if (fig instanceof RectangleType) {
			return adapt((RectangleType) fig);
		} else if (fig instanceof LineType) {
			return adapt((LineType) fig);
		} else if (fig instanceof CompositeType) {
			return adapt((CompositeType) fig);
		}
		throw new RuntimeException("Unknown type to adapt");
	}
	
	public static LineInterface adapt(LineType lineType) {
		return new Line(lineType);
	}

	
}
