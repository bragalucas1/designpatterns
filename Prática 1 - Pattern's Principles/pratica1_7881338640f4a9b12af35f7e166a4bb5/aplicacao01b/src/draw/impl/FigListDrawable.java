package draw.impl;

import java.awt.Graphics;
import draw.interfaces.DrawableInterface;
import fig.impl.FigList;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;

/**
 * Classe concreta para representar lista de figuras
 * que pode ser desenhada, usando herança
 * @author Vladimir Oliveira Di Iorio
 */
public class FigListDrawable 
extends FigList
implements FigListInterface, DrawableInterface {
	
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
