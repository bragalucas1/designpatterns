package fig.interfaces;

import java.awt.Color;

/**
 * Fábrica abstrata para criação de figuras geométricas.
 * @author Vladimir Oliveira Di Iorio
 */
public interface FigFactoryInterface {

	/**
	 * Método para criação de listas de figuras.
	 * @return Lista criada.
	 */
	FigListInterface createFigList();
	
	/**
	 * Método para criação de círculos.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param radius Raio do círculo.
	 * @return Círculo criado.
	 */
	CircleInterface createCircle(
			int posX, int posY, Color color, int radius);
	
	/**
	 * Método para criação de retângulos.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param width Largura.
	 * @param height Altura.
	 * @return Retângulo criado.
	 */
	RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height);
	
	/**
	 * Método para criação de figuras compostas.
	 * @return Figura composta criada.
	 */
	CompositeInterface createComposite();
	
	/**
	 * Método para criação de linhas.
	 * @param posX Posição horizontal do primeiro ponto.
	 * @param posY Posição vertical do primeiro ponto.
	 * @param color Cor da borda.
	 * @param posX2 Posição horizontal do segundo ponto.
	 * @param posY2 Posição vertical do segundo ponto.
	 * @return Linha criada.
	 */
	LineInterface createLine(
	int posX, int posY, Color color, int posX2, int posY2);
	
}
