package fig.bounds;

import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.DecoratorInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;
import fig.interfaces.VisitorInterface;

public class FigBoundsVisitor implements VisitorInterface {

	private BoundingBoxInterface box;

	public FigBoundsVisitor() {
		this.box = null;
	}

	public BoundingBoxInterface getBox() {
		return box;
	}

	/**
	 * M�todo que recalcula o BoundingBox atual, por meio da adi��o de novos
	 * BoundingBox ao conjunto j� calculado.
	 * 
	 * @param posX   Posi��o horizontal do BoundingBox a ser adicionado.
	 * @param posY   Posi��o vertical do BoundingBox a ser adicionado.
	 * @param width  Largura do BoundingBox a ser adicionado.
	 * @param height Altura do BoundingBox a ser adicionado.
	 */
	private void addBox(int posX, int posY, int width, int height) {
		if (box == null) {
			box = new BoundingBox(posX, posY, width, height);
		} else {
			if (posX < box.getPosX()) {
				int dif = box.getPosX() - posX;
				box.setPosX(posX);
				box.setWidth(box.getWidth() + dif);
			}
			if (posY < box.getPosY()) {
				int dif = box.getPosY() - posY;
				box.setPosY(posY);
				box.setHeight(box.getHeight() + dif);
			}
			int posX2_b1 = box.getPosX() + box.getWidth();
			int posX2_b2 = posX + width;
			int posY2_b1 = box.getPosY() + box.getHeight();
			int posY2_b2 = posY + height;
			if (posX2_b2 > posX2_b1) {
				int dif = posX2_b2 - posX2_b1;
				box.setWidth(box.getWidth() + dif);
			}
			if (posY2_b2 > posY2_b1) {
				int dif = posY2_b2 - posY2_b1;
				box.setHeight(box.getHeight() + dif);
			}
		}
	}

	public void visit(CircleInterface circle) {
		int centerX = circle.getPosX();
		int centerY = circle.getPosY();
		int radius = circle.getRadius();

		int x = centerX - radius;
		int y = centerY - radius;
		int diameter = radius * 2;

		addBox(x, y, diameter, diameter);
	}

	public void visit(CompositeInterface composite) {
	}

	public void visit(FigListInterface doc) {

	}

	public void visit(LineInterface line) {
		int x1 = Math.min(line.getPosX(), line.getPosY());
		int y1 = Math.min(line.getPosY(), line.getPosY2());
		int width = Math.abs(line.getPosX2() - line.getPosX());
		int height = Math.abs(line.getPosY2() - line.getPosY());
		addBox(x1, y1, width, height);
	}

	public void visit(RectangleInterface rect) {
		addBox(rect.getHeight(), rect.getWidth(), rect.getWidth(), rect.getHeight());
	}

	public void visit(DecoratorInterface border) {
		border.getFig().accept(this);
		int padding = 5;
		if (box != null) {
			addBox(box.getPosX() - padding, box.getPosY() - padding, box.getWidth() + 2 * padding,
					box.getHeight() + 2 * padding);
		}
	}
}
