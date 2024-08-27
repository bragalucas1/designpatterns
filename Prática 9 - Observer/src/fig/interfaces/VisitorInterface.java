package fig.interfaces;

import fig.interfaces.*;

public interface VisitorInterface {

	void visit(CircleInterface circle);
	void visit(RectangleInterface rect);
	void visit(LineInterface line);
	void visit(CompositeInterface composite);
	void visit(FigListInterface l);

}
