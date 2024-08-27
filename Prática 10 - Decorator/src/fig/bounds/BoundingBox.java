
package fig.bounds;


public class BoundingBox implements BoundingBoxInterface {
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	public BoundingBox(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
	
	public int getPosX() { return posX; }
	public int getPosY() { return posY; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}