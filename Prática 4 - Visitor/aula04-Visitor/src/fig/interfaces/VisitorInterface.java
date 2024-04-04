package fig.interfaces;

public interface VisitorInterface {

	void visit(CircleInterface circle);
	void visit(RectangleInterface rect);
	void visit(CompositeInterface composite);
	void visit(FigListInterface l);
	void visit(LineInterface line);

}
