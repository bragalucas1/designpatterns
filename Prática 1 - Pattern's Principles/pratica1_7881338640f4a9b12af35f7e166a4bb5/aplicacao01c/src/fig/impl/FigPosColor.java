/**
 * 
 */
package fig.impl;

import fig.interfaces.FigPosColorInterface;
import java.awt.Color;

/**
 * Classe concreta para representar figura com atributos ponto e cor.
 * É abstrata porque não se tem intenção de instanciar objetos dessa classe,
 * ela serve apenas para compor a hierarquia.
 * @author   Vladimir Oliveira Di Iorio
 */
abstract class FigPosColor
implements FigPosColorInterface {
	
	/**
	 * Posição horizontal.
	 */
	private int posX;
	
	/**
	 * Posição vertical.
	 */
	private int posY;
	
	/**
	 * Cor da figura.
	 */
	private Color color;
	
	/**
	 * Constrói figura.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da figura.
	 */
	public FigPosColor(int posX, int posY, Color color) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}
	
	/**
	 * @see FigPosColorInterface#getPosX()
	 */
	public int getPosX() { return posX; }
	
	/**
	 * @see FigPosColorInterface#getPosY()
	 */
	public int getPosY() { return posY; }
	
	/**
	 * @see FigPosColorInterface#setPosX(int)
	 */
	public void setPosX(int posX) { this.posX = posX; }
	
	/**
	 * @see FigPosColorInterface#setPosY(int)
	 */
	public void setPosY(int posY) { this.posY = posY; }
	
	/**
	 * @see FigPosColorInterface#getAWTColor()
	 */
	public Color getAWTColor() { return color; }
	
	/**
	 * @see FigPosColorInterface#setAWTColor(Color)
	 */
	public void setAWTColor(Color color) { this.color = color; }
	
}
