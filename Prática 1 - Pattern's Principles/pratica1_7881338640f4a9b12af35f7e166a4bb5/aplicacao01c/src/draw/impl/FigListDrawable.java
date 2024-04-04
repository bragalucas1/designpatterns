package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import java.awt.Graphics;
import java.util.Iterator;

/**
 * Classe concreta que representa lista de figuras que pode ser desenhada, usando composição e delegação.
 * @author   Vladimir Oliveira Di Iorio
 */
public class FigListDrawable
implements FigListInterface, DrawableInterface {

	/**
	 * Referência para interface que representa
	 * lista de figuras.
	 */
	private FigListInterface figList;
	
	/**
	 * Constrói lista de figuras que pode ser desenhada.
	 * @param figList Interface que representa lista de figuras.
	 */
	public FigListDrawable(FigListInterface figList) {
		this.figList = figList;
	}
	
	/**
	 * @see fig.interfaces.FigListInterface#addFig(fig.interfaces.FigInterface)
	 */
	public void addFig(FigInterface fig) {
		assert(fig instanceof DrawableInterface);
		figList.addFig(fig);
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<FigInterface> iterator() {
		return figList.iterator();
	}
	
	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		for (FigInterface x : this) {
			DrawableInterface fig = (DrawableInterface) x;
			fig.awtDraw(g);
		}
	}
	
}
