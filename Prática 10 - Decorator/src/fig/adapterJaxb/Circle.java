package fig.adapterJaxb;

import fig.interfaces.CircleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.CircleType;

public class Circle extends FigPosColor implements CircleInterface {
	
	public Circle(CircleType circleType) {
		super(circleType);
	}
		
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getRadius() {
		return ((CircleType) figPosColorType).getRadius();
	}

	public void setRadius(int value) {
		((CircleType) figPosColorType).setRadius(value);
	}
	
}
