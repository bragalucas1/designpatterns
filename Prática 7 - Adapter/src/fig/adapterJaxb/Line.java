package fig.adapterJaxb;

import java.awt.Color;

import fig.interfaces.LineInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.LineType;

public class Line implements LineInterface {

	LineType lineType;

	public Line(LineType lineType) {
		this.lineType = lineType;
	}

	public Color getAWTColor() {
		return ColorAdapter.stringToColor(lineType.getColor());
	}

	public void setAWTColor(Color color) {
		lineType.setColor(ColorAdapter.colorToString(color));
	}

	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getPosX2() {
		return lineType.getPosX2();
	}

	public void setPosX2(int value) {
		lineType.setPosX2(value);
	}

	public int getPosY2() {
		return lineType.getPosY2();
	}

	public void setPosY2(int value) {
		lineType.setPosY2(value);
	}

	@Override
	public int getPosX() {
		return lineType.getPosX();
	}

	@Override
	public int getPosY() {
		return lineType.getPosY();
	}

	@Override
	public void setPosX(int posX) {
		lineType.setPosX(posX);
	}

	@Override
	public void setPosY(int posY) {
		lineType.setPosY(posY);
	}

}
