package fig.adapterJaxb;

import java.awt.Color;

import fig.xmlclasses.FigPosColorType;

public class FigPosColor {
	
	protected FigPosColorType figPosColorType;
	
	public FigPosColor(FigPosColorType figPosColorType) {
		super();
		this.figPosColorType = figPosColorType;
	}

	public int getPosX() {
		return figPosColorType.getPosX();
	}

	public void setPosX(int value) {
		figPosColorType.setPosX(value);
	}

	public int getPosY() {
		return figPosColorType.getPosY();
	}

	public void setPosY(int value) {
		figPosColorType.setPosY(value);
	}
	
	public Color getAWTColor() {
		return ColorAdapter.stringToColor(figPosColorType.getColor());
	}

	public void setAWTColor(Color color) {
		figPosColorType.setColor(ColorAdapter.colorToString(color));
	}

}
