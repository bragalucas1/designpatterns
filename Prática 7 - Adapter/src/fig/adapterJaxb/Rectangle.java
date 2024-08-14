package fig.adapterJaxb;

import java.awt.Color;

import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.RectangleType;

public class Rectangle implements RectangleInterface {

	RectangleType rectangleType;

	public Rectangle(RectangleType rectangleType) {
		this.rectangleType = rectangleType;
	}
	
	public Color getAWTColor() {
		return ColorAdapter.stringToColor(rectangleType.getColor());
	}

	public void setAWTColor(Color color) {
		rectangleType.setColor(ColorAdapter.colorToString(color));
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getWidth() {
		return rectangleType.getWidth();
	}

	public void setWidth(int value) {
		rectangleType.setWidth(value);
	}

	public int getHeight() {
		return rectangleType.getHeight();
	}

	public int getPosX() {
		return rectangleType.getPosX();
	}

	public void setHeight(int value) {
		rectangleType.setHeight(value);
	}

	public void setPosX(int value) {
		rectangleType.setPosX(value);
	}

	public int getPosY() {
		return rectangleType.getPosY();
	}

	public void setPosY(int value) {
		rectangleType.setPosY(value);
	}

}
