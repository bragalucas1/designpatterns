package fig.builder;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import fig.xmlclasses.CircleType;
import fig.xmlclasses.CompositeType;
import fig.xmlclasses.FigDoc;
import fig.xmlclasses.LineType;
import fig.xmlclasses.RectangleType;

public class BuilderSvg implements JaxbBuilderInterface {
	private PrintStream file;

// construtor recebe como parâmetro nome do arquivo de saída a ser gerado
	public BuilderSvg(String fileName) {
		try {
			file = new PrintStream(fileName + ".svg");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void initDoc(FigDoc doc) {
		file.println(
				"<svg width=\"100%\" height=\"100%\" version=\"1.1\"" + "\nxmlns=\"http://www.w3.org/2000/svg\">\n");
	}

	public void endDoc() {
		file.println("\n</svg>");
		file.close();
	}

	public void initComposite(CompositeType composite) {
	}

	public void endComposite() {
	}

	public void buildCircle(CircleType circle) {
		file.println("<circle cx=\"" + circle.getPosX() + "\" cy=\"" + circle.getPosY() + "\" r=\"" + circle.getRadius()
				+ "\" style=\"fill-opacity:0;stroke:#" + circle.getColor() + "\" />");
	}

	public void buildRectangle(RectangleType rectangle) {
		file.println("<rect x=\"" + rectangle.getPosX() + "\" y=\"" + rectangle.getPosY() + "\" width=\""
				+ rectangle.getWidth() + "\" height=\"" + rectangle.getHeight() + "\" style=\"fill-opacity:0;stroke:#"
				+ rectangle.getColor() + "\" />");
	}

	public void buildLine(LineType line) {
		file.println("<line x1=\"" + line.getPosX() + "\" y1=\"" + line.getPosY()
				+ "\" x2=\"200\" y2=\"200\" style=\"fill-opacity:0;stroke:#" + line.getColor() + "\" />");
	}

}