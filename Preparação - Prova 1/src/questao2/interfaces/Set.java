package questao2.interfaces;

public interface Set<T> extends Iterable<T> {
	/**
	 * Adiciona elemento ao conjunto. Se o conjunto já contiver
	 * o elemento, nenhuma operação é executada.
	 * @param t Elemento a ser inserido no conjunto.
	 */
	void add(T t);
	
	/**
	 * Verfica se o conjunto contém um elemento.
	 * @param t Elemento a ser procurado no conjunto.
	 * @return true, se encontrar; false, caso contrário.
	 */
	boolean contains(T t);
	
	/**
	 * Verifica se o conjunto é vazio;
	 * @return true, se vazio; false, caso contrário.
	 */
	boolean isEmpty();
	
	/**
	 * Retorna número de elementos no conjunto.
	 * @return Número de elementos.
	 */
	int size();

}
