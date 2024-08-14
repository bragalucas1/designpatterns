package fig.adapterJaxb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigListType;
import fig.xmlclasses.FigType;
import fig.xmlclasses.LineType;
import fig.xmlclasses.ObjectFactory;
import fig.xmlclasses.RectangleType;

public class FigList implements FigListInterface {

	FigListType figListType;
	List<FigInterface> listOfInterfaces;

	public FigList(FigListType figListType) {
		this.figListType = figListType;
		listOfInterfaces = new ArrayList<FigInterface>();

		for (JAXBElement<? extends FigType> x : figListType.getFigElement()) {
			FigType y = x.getValue();
			FigInterface z = null;
			if (y instanceof CircleType) {
				z = new Circle((CircleType) y);
			} else if (y instanceof RectangleType) {
				z = new Rectangle((RectangleType) y);
			} else if (y instanceof LineType) {
				z = new Line((LineType) y);
			} else if (y instanceof CompositeType) {
				z = new Composite((CompositeType) y);
			}
			listOfInterfaces.add(z);
		}

	}

	public Iterator<FigInterface> iterator() {
		return listOfInterfaces.iterator();
	}

	private fig.xmlclasses.ObjectFactory fac = new ObjectFactory();

	public void addFig(FigInterface fig) {
		if (!(fig instanceof Circle) && !(fig instanceof Rectangle) && !(fig instanceof Line)
				&& !(fig instanceof Composite)) {
			throw new RuntimeException("object should have been created using fig.adapter factory");
		}
		JAXBElement<? extends FigType> x = null;
		if (fig instanceof CircleInterface) {
			x = fac.createCircle(((Circle) fig).circleType);
		} else if (fig instanceof RectangleInterface) {
			x = fac.createRectangle(((Rectangle) fig).rectangleType);
		} else if (fig instanceof LineInterface) {
			x = fac.createLine(((Line) fig).lineType);
		} else if (fig instanceof CompositeInterface) {
			CompositeType aux = fac.createCompositeType();
			aux.setFigList(((Composite) fig).figListType);
			x = fac.createComposite(aux);
		}
		figListType.getFigElement().add(x);
		listOfInterfaces.add(fig);
	}

	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

}
