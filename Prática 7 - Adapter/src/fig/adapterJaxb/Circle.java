package fig.adapterJaxb;

import java.awt.Color;

import fig.interfaces.CircleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.CircleType;

public class Circle
implements CircleInterface {

	CircleType circleType;
	
	public Circle(CircleType circleType) {
		this.circleType = circleType;
	}
	
	public Color getAWTColor() {
		return ColorAdapter.stringToColor(circleType.getColor());
	}

	public void setAWTColor(Color color) {
		circleType.setColor(ColorAdapter.colorToString(color));
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getRadius() {
		return circleType.getRadius();
	}

	public void setRadius(int value) {
		circleType.setRadius(value);
	}

	public int getPosX() {
		return circleType.getPosX();
	}

	public void setPosX(int value) {
		circleType.setPosX(value);
	}

	public int getPosY() {
		return circleType.getPosY();
	}

	public void setPosY(int value) {
		circleType.setPosY(value);
	}

	
}
