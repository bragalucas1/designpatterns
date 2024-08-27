package fig.interfaces;

/**
 * Interface para representar segmentos de reta.
 * @author   Vladimir Oliveira Di Iorio
 */
public interface LineInterface extends FigPosColorInterface {

	
	/**
	 * Obtém posição horizontal do segundo ponto.
	 * @return Posição horizontal do segundo ponto.
	 */
	int getPosX2();
	
	/**
	 * Obtém posição vertical do segundo ponto.
	 * @return Posição vertical do segundo ponto.
	 */
	int getPosY2();
	
	/**
	 * Altera posição horizontal do segundo ponto,
	 * sem alterar os demais atributos.
	 * @param posX2 Nova posição horizontal do segundo ponto.
	 */
	void setPosX2(int posX2);
	
	/**
	 * Altera posição vertical do segundo ponto,
	 * sem alterar os demais atributos.
	 * @param posY2 Nova posição vertical do segundo ponto.
	 */
	void setPosY2(int posY2);
	
}
