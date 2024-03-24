package draw.impl;

import draw.interfaces.DrawableInterface;
import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import java.awt.Graphics;
import java.util.Iterator;

/**
 * Classe concreta que representa lista de figuras que pode ser desenhada, usando composi��o e delega��o.
 * @author   Vladimir Oliveira Di Iorio
 */
public class FigListDrawable
implements FigListInterface, DrawableInterface {

	/**
	 * Refer�ncia para interface que representa
	 * lista de figuras.
	 */
	private FigListInterface figList;
	
	/**
	 * Constr�i lista de figuras que pode ser desenhada.
	 * @param figList Interface que representa lista de figuras.
	 */
	public FigListDrawable(FigListInterface figList) {
		this.figList = figList;
	}
	
	/**
	 * @see fig.interfaces.FigListInterface#addFig(fig.interfaces.FigInterface)
	 */
	public void addFig(FigInterface fig) {
		assert(fig instanceof DrawableInterface);
		figList.addFig(fig);
	}

	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<FigInterface> iterator() {
		return figList.iterator();
	}
	
	/**
	 * @see draw.interfaces.DrawableInterface#awtDraw(java.awt.Graphics)
	 */
	public void awtDraw(Graphics g) {
		Iterator<FigInterface> iterator = this.iterator();
		while(iterator.hasNext()) {
			FigInterface figToDraw = iterator.next();
			DrawableInterface fig = (DrawableInterface) figToDraw;
			fig.awtDraw(g);
		}
		
//		Neste código, em vez de usar o loop for-each, 
//		estamos obtendo um objeto Iterator chamando o método iterator() na lista this. 
//		Em seguida, usamos um loop while para iterar sobre os elementos, verificando se há mais elementos com o método hasNext(), 
//		e obtendo o próximo elemento com o método next(). Este código realiza a mesma operação que o código original, 
//		mas usando explicitamente a classe Iterator.
	}
	
}
