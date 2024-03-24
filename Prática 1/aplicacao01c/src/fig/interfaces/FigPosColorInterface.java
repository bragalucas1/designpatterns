package fig.interfaces;

import java.awt.Color;

/**
 * Interface para figuras que armazenam posição e cor.
 * @author   Vladimir Oliveira Di Iorio
 */
public interface FigPosColorInterface
extends FigInterface {
	
	/**
	 * Obtém posição horizontal.
	 * @return Posição horizontal da figura.
	 */
	int getPosX();
	
	/**
	 * Obtém posição vertical.
	 * @return Posição vertical da figura.
	 */
	int getPosY();
	
	/**
	 * Altera posição horizontal da figura,
	 * sem alterar os demais atributos.
	 * @param posX Nova posição horizontal.
	 */
	void setPosX(int posX);
	
	/**
	 * Altera posição vertical da figura,
	 * sem alterar os demais atributos.
	 * @param posY Nova posição vertical.
	 */
	void setPosY(int posY);
	
	/**
	 * Obtém cor da figura.
	 * @return Cor da figura, no formato de classe
	 * java.awt.Color.
	 */
	Color getAWTColor();
	
	/**
	 * Altera cor da figura,
	 * sem alterar os demais atributos.
	 * @param color Nova cor da figura.
	 */
	void setAWTColor(Color color);

}
