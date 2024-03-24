package testes.factorymethod;

import draw.interfaces.DrawableInterface;
import exibicao.Exibidor;
import fig.interfaces.CircleInterface;
import fig.interfaces.CompositeInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.RectangleInterface;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * Classe abstrata que aplica o padrão de projeto Factory Method.
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
	 * Construtor, sem parâmetros.
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
	 * Método abstrato para criação de listas de figuras.
	 * @return Lista criada.
	 */
	public abstract FigListInterface createFigList();
	
	/**
	 * Método abstrato para criação de retângulos.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param width Largura.
	 * @param height Altura.
	 * @return Retângulo criado.
	 */
	public abstract RectangleInterface createRectangle(
			int posX, int posY, Color color, int width, int height);
	
	/**
	 * Método abstrato para criação de círculos.
	 * @param posX Posição horizontal.
	 * @param posY Posição vertical.
	 * @param color Cor da borda.
	 * @param radius Raio do círculo.
	 * @return Círculo criado.
	 */
	public abstract CircleInterface createCircle(
			int posX, int posY, Color color, int radius);
	
	/**
	 * Método abstrato para criação de figuras compostas.
	 * @return Figura composta criada.
	 */
	public abstract CompositeInterface createComposite();
	
	/**
	 * Constrói uma lista de figuras.
	 * OBS: UTILIZA MÉTODOS FÁBRICA (ABSTRATOS).
	 * @return Lista de figuras construída.
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
		return figs;
	}

}
