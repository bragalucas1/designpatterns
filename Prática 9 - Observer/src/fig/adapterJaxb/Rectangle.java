package fig.adapterJaxb;

import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.RectangleType;

public class Rectangle extends FigPosColor implements RectangleInterface {

	public Rectangle(RectangleType rectangleType) {
		super(rectangleType);
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getWidth() {
		return ((RectangleType) figPosColorType).getWidth();
	}

	public void setWidth(int value) {
		((RectangleType) figPosColorType).setWidth(value);
	}

	public int getHeight() {
		return ((RectangleType) figPosColorType).getHeight();
	}

	public void setHeight(int value) {
		((RectangleType) figPosColorType).setHeight(value);
	}

}
