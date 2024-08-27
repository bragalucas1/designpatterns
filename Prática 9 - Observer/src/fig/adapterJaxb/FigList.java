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
	
	private FigListType figListType;
	private List<FigInterface> listOfInterfaces;
	private fig.xmlclasses.ObjectFactory fac;

	public FigList(FigListType figListType) {
		this.figListType = figListType;
		listOfInterfaces = new ArrayList<FigInterface>();
		fac = new ObjectFactory();
	
		for (JAXBElement<? extends FigType> x: figListType.getFigElement()) {
			FigType y = x.getValue();
			FigInterface z = Adapter.adapt(y);
			listOfInterfaces.add(z);
		}		
	}
	
	public Iterator<FigInterface> iterator() {
		return listOfInterfaces.iterator();
	}

	public void addFig(FigInterface fig) {
		if (! (fig instanceof Circle)
				&& ! (fig instanceof Rectangle)
				&& ! (fig instanceof Line)
				&& ! (fig instanceof Composite)
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
		}
		figListType.getFigElement().add(x);
		listOfInterfaces.add(fig);
	}
	
	public void removeFig(FigInterface fig) {
		int i = listOfInterfaces.indexOf(fig);
		if (i != -1) {
			listOfInterfaces.remove(i);
			figListType.getFigElement().remove(i);
		}
	}

	public void accept(VisitorInterface visitor) {
		visitor.visit(this);		
	}
	
	/**
	 * Este método não faz parte da interface FigListInterface.
	 * Usado apenas nas operações de gravação de dados em formato XML,
	 * até que se encontre forma mais elegante.
	 * @return
	 */
	public FigListType getFigListType() {
		return figListType;
	}

}
