package draw.interfaces;

import java.awt.Graphics;

/**
 * Interface para objetos que podem ser desenhados
 * em um contexto gráfico.
 * @author Vladimir Oliveira Di Iorio
 */
public interface DrawableInterface {
	
	/**
	 * Desenha um objeto em contexto gráfico.
	 * @param g Contexto gráfico onde objeto será desenhado.
	 */
	void awtDraw(Graphics g);
}
