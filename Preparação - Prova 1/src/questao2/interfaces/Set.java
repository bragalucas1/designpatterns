package questao2.interfaces;

public interface Set<T> extends Iterable<T> {
	/**
	 * Adiciona elemento ao conjunto. Se o conjunto j� contiver
	 * o elemento, nenhuma opera��o � executada.
	 * @param t Elemento a ser inserido no conjunto.
	 */
	void add(T t);
	
	/**
	 * Verfica se o conjunto cont�m um elemento.
	 * @param t Elemento a ser procurado no conjunto.
	 * @return true, se encontrar; false, caso contr�rio.
	 */
	boolean contains(T t);
	
	/**
	 * Verifica se o conjunto � vazio;
	 * @return true, se vazio; false, caso contr�rio.
	 */
	boolean isEmpty();
	
	/**
	 * Retorna n�mero de elementos no conjunto.
	 * @return N�mero de elementos.
	 */
	int size();

}
