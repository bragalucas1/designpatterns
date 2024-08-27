package fig.interfaces;

import java.awt.Color;

/**
 * F�brica abstrata para cria��o de figuras geom�tricas.
 * @author Vladimir Oliveira Di Iorio
 */
public interface FigFactoryInterface {

	/**
	 * M�todo para cria��o de listas de figuras.
	 * @return Lista criada.
	 */
	FigListInterface createFigList();
	
	/**
	 * M�todo para cria��o de c�rculos.
	 * @param posX Posi��o horizontal.
	 * @param posY Posi��o vertical.
	 * @param color Cor da borda.
	 * @param radius Raio do c�rculo.
	 * @return C�rculo criado.
	 */
	CircleInterface createCircle(
			int posX, int posY, Color color, int radius);
	
	/**
	 * M�todo para cria��o de ret�ngulos.
	 * @param posX Posi��o horizontal.
	 * @param posY Posi��o vertical.
	 * @param color Cor da borda.
	 * @param width Largura.
	 * @param height Altura.
	 * @return Ret�ngulo criado.
	 */
	RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height);
	
	/**
	 * M�todo para cria��o de figuras compostas.
	 * @return Figura composta criada.
	 */
	CompositeInterface createComposite();
	
	/**
	 * M�todo para cria��o de linhas.
	 * @param posX Posi��o horizontal do primeiro ponto.
	 * @param posY Posi��o vertical do primeiro ponto.
	 * @param color Cor da borda.
	 * @param posX2 Posi��o horizontal do segundo ponto.
	 * @param posY2 Posi��o vertical do segundo ponto.
	 * @return Linha criada.
	 */
	LineInterface createLine(
	int posX, int posY, Color color, int posX2, int posY2);
	
}
