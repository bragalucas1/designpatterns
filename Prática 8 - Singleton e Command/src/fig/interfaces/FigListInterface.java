package fig.interfaces;

import fig.interfaces.FigInterface;

/**
 * Interface para lista de figuras.
 * @author Vladimir Oliveira Di Iorio
 */
public interface FigListInterface
extends Iterable<FigInterface> {
		
	/**
	 * Acrescenta figura no final da lista.
	 * @param fig Figura a ser acrescentada.
	 */
	void addFig(FigInterface fig);
	
	/**
	 * Remove figura da lista.
	 * @param fig Figura a ser removida.
	 */
	void removeFig(FigInterface fig);
	
	void accept(VisitorInterface visitor);
	
}
