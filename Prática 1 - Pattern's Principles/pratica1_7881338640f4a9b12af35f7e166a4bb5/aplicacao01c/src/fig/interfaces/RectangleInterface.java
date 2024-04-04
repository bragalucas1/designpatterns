package fig.interfaces;

/**
 * Interface para representar retângulos.
 * @author   Vladimir Oliveira Di Iorio
 */
public interface RectangleInterface extends FigPosColorInterface {

	/**
	 * Obtém a largura do retângulo.
	 * @return Largura do retângulo.
	 */
	int getWidth();
	
	/**
	 * Obtém a altura do retângulo.
	 * @return Altura do retângulo.
	 */
	int getHeight();
	
	/**
	 * Altera a largura do retângulo,
	 * sem modificar os demais atributos.
	 * @param width Nova largura.
	 */
	void setWidth(int width);

	/**
	 * Altera a altura do retângulo,
	 * sem modificar os demais atributos.
	 * @param height Nova altura.
	 */
	void setHeight(int height);
	
}
