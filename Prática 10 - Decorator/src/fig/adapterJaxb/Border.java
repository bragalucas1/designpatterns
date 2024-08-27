package fig.adapterJaxb;

import javax.xml.bind.JAXBElement;

import fig.interfaces.DecoratorInterface;
import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.BorderType;
import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.ObjectFactory;
import fig.xmlclasses.RectangleType;

public class Border implements DecoratorInterface {

	BorderType borderType;
	FigInterface fig;
	private fig.xmlclasses.ObjectFactory fac;
	
	public Border(BorderType borderType) {
		this.borderType = borderType;
		JAXBElement<? extends FigType> x = borderType.getFigElement();
		FigType y = x.getValue();
		fig = Adapter.adapt(y);
		fac = new ObjectFactory();
	}

	@Override
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);		
	}

	@Override
	public FigInterface getFig() {
		return fig;
//		return borderType.getFigElement();
	}


	@Override
	public void setFig(FigInterface fig) {
		if (! (fig instanceof Circle)
				&& ! (fig instanceof Rectangle)
				&& ! (fig instanceof Line)
				&& ! (fig instanceof Composite)
				&& ! (fig instanceof Border)
			) {
			throw new RuntimeException("object should have been created using fig.adapter factory");
		}
		JAXBElement<? extends FigType> x = null;
		if (fig instanceof CircleInterface) {
			x = fac.createCircle((CircleType) ((Circle) fig).figPosColorType);
		} else if (fig instanceof RectangleInterface) {
			x = fac.createRectangle((RectangleType) ((Rectangle) fig).figPosColorType);
		} else if (fig instanceof LineInterface) {
			x = fac.createLine((LineType) ((Line) fig).figPosColorType);
		} else if (fig instanceof CompositeInterface) {
			CompositeType aux = fac.createCompositeType();
			aux.setFigList(((FigList) fig).figListType);
			x = fac.createComposite(aux);
		} else if (fig instanceof DecoratorInterface) {
			x = fac.createBorder(((Border) fig).borderType);
		}
		borderType.setFigElement(x);
		this.fig = fig;
	}

}
