package testes.factorymethod;

import draw.interfaces.DrawableInterface;
import exibicao.Exibidor;
import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.LineInterface;
import fig.interfaces.RectangleInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Classe abstrata que aplica o padr�o de projeto Factory Method.
 * @author  Vladimir Oliveira Di Iorio
 */
public abstract class InterfaceGrafica extends JFrame {
	
	/**
	 * Documento com figuras.
	 */
	private FigListInterface figDoc;
	
	/**
	 * Exibidor de figuras que usa polimorfismo.
	 */
	Exibidor exibidor;

	/**
	 * Construtor, sem par�metros.
	 */
	public InterfaceGrafica() {
		super("Teste");
		figDoc = constroiDados();
		exibidor = new Exibidor((DrawableInterface) figDoc);
		add(exibidor);
	    setSize (300, 300);
	    setVisible(true);
	    addWindowListener(
	    	new WindowAdapter() {
	    		public void windowClosing(WindowEvent e) {
	    			System.exit( 0 );
	    		}
	    	}
	    );
	}

	/**
	 * M�todo abstrato para cria��o de listas de figuras.
	 * @return Lista criada.
	 */
	public abstract FigListInterface createFigList();
	
	/**
	 * M�todo abstrato para cria��o de ret�ngulos.
	 * @param posX Posi��o horizontal.
	 * @param posY Posi��o vertical.
	 * @param color Cor da borda.
	 * @param width Largura.
	 * @param height Altura.
	 * @return Ret�ngulo criado.
	 */
	public abstract RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height);
	
	/**
	 * M�todo abstrato para cria��o de linha.
	 * @param posX Posi��o horizontal.
	 * @param posY Posi��o vertical.
	 * @param color Cor da linha.
	 * @param posX2.
	 * @param posY2.
	 * @return Linha criada.
	 */
	
	public abstract LineInterface createLine(
			int posX, int posY, Color color, int posX2, int posY2);
	
	/**
	 * M�todo abstrato para cria��o de c�rculos.
	 * @param posX Posi��o horizontal.
	 * @param posY Posi��o vertical.
	 * @param color Cor da borda.
	 * @param radius Raio do c�rculo.
	 * @return C�rculo criado.
	 */
	public abstract CircleInterface createCircle(
			int posX, int posY, Color color, int radius);
	
	/**
	 * M�todo abstrato para cria��o de figuras compostas.
	 * @return Figura composta criada.
	 */
	public abstract CompositeInterface createComposite();
	
	/**
	 * Constr�i uma lista de figuras.
	 * OBS: UTILIZA M�TODOS F�BRICA (ABSTRATOS).
	 * @return Lista de figuras constru�da.
	 */
	private FigListInterface constroiDados() {
		FigListInterface figs = createFigList();
		figs.addFig(createRectangle(60, 40, Color.BLUE, 50, 30));
		figs.addFig(createCircle(30, 30, Color.RED, 20));
		CompositeInterface c = createComposite();
		c.addFig(createCircle(150, 50, Color.ORANGE, 20));
		c.addFig(createRectangle(180, 60, Color.BLACK, 50, 30));
		figs.addFig(c);
		figs.addFig(createRectangle(30, 110, Color.MAGENTA, 50, 30));
		figs.addFig(createLine(5, 20, Color.GREEN, 20, 20));
		return figs;
	}

}
