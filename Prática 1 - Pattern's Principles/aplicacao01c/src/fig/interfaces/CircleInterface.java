package fig.interfaces;

/**
 * Interface para representar círculos.
 * @author   Vladimir Oliveira Di Iorio
 */
public interface CircleInterface extends FigPosColorInterface {

	/**
	 * Obtém o raio do círculo.
	 * @return Raio do círculo.
	 */
	int getRadius();
	
	/**
	 * Altera o raio do círculo, sem modificar
	 * os demais atributos.
	 * @param radius Novo valor do raio.
	 */
	void setRadius(int radius);
	
}
