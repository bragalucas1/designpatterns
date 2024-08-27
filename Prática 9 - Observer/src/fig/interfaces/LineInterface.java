package fig.interfaces;

/**
 * Interface para representar segmentos de reta.
 * 
 * @author Vladimir Oliveira Di Iorio
 */
public interface LineInterface extends FigPosColorInterface {

	/**
	 * Obt�m posi��o horizontal do segundo ponto.
	 * 
	 * @return Posi��o horizontal do segundo ponto.
	 */
	int getPosX2();

	/**
	 * Obt�m posi��o vertical do segundo ponto.
	 * 
	 * @return Posi��o vertical do segundo ponto.
	 */
	int getPosY2();

	/**
	 * Altera posi��o horizontal do segundo ponto, sem alterar os demais atributos.
	 * 
	 * @param posX2 Nova posi��o horizontal do segundo ponto.
	 */
	void setPosX2(int posX2);

	/**
	 * Altera posi��o vertical do segundo ponto, sem alterar os demais atributos.
	 * 
	 * @param posY2 Nova posi��o vertical do segundo ponto.
	 */
	void setPosY2(int posY2);

}
