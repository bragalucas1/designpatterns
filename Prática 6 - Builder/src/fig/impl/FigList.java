package fig.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fig.interfaces.FigInterface;
import fig.interfaces.FigListInterface;
import fig.interfaces.VisitorInterface;

/**
 * Classe concreta para representar lista de figuras.
 * @author Vladimir Oliveira Di Iorio
 */
public class FigList
implements FigListInterface {
	
	/**
	 * Lista que armazena as figuras.
	 */
	private List<FigInterface> list;
	
	/**
	 * Construtor, sem parâmetros.
	 */
	public FigList() {
		list = new ArrayList<FigInterface>();
	}
	
	/**
	 * @see FigListInterface#addFig(FigInterface)
	 */
	public void addFig(FigInterface fig) { list.add(fig); }
	
	/**
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<FigInterface> iterator() {
		return list.iterator();
	}
	
	public void accept(VisitorInterface visitor) {
		visitor.visit(this);
	}

}
