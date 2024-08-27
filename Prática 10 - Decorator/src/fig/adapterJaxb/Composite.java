package fig.adapterJaxb;

import fig.interfaces.CompositeInterface;
import fig.interfaces.VisitorInterface;
import fig.xmlclasses.CompositeType;

public class Composite extends FigList implements CompositeInterface {
	
	public Composite(CompositeType compositeType) {
		super(compositeType.getFigList());
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);		
	}

}
