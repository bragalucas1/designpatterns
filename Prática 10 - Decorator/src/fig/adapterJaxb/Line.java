package fig.adapterJaxb;

import fig.interfaces.LineInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.LineType;

public class Line extends FigPosColor implements LineInterface {

	public Line(LineType lineType) {
		super(lineType);
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

	public int getPosX2() {
		return ((LineType) figPosColorType).getPosX2();
	}

	public void setPosX2(int value) {
		((LineType) figPosColorType).setPosX2(value);
	}

	public int getPosY2() {
		return ((LineType) figPosColorType).getPosY2();
	}

	public void setPosY2(int value) {
		((LineType) figPosColorType).setPosY2(value);
	}

}
