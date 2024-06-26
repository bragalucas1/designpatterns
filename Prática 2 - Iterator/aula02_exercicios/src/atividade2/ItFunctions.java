package atividade2;
import java.util.Iterator;
import java.util.List;

public class ItFunctions {
	//Iteradores fornecem uma vida para acessar os elementos de um conjunto sequencialmente sem expor sua implementa��o em si.
	//Simplificam a interface do Agregado, permitindo que mais de um caminhamento seja realizado simultaneamente.
	//Sua cria��o e manuten��o pode trazer um custo adicional em termos de mem�ria e tempo.
	//Use of an iterator simplifies the code and makes it general. Benefits of using this iterator 
	//API include: treats variables of all types, sizes, and shapes uniformly, whether they fit in memory or not, 
	//even if a single row won't fit in memory. makes recursion unnecessary in handling arrays of arbitrary dimensionality.
	
	
	static int findMax(Iterable<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int maxValue = Integer.MIN_VALUE;
		while(it.hasNext()) {
			int currentIterable = it.next();
			if(currentIterable > maxValue) {
				maxValue = currentIterable;
			}
		}
		return maxValue;
	}
	
	static <E> int numOccurences(Iterable<E> list, E e) {
		Iterator<E> it = list.iterator();
		int counter = 0;
		while(it.hasNext()) {
			E currentValue = it.next();
			if(currentValue == e) {
				counter++;
			}
		}
		return counter;
	}
	
	static boolean isNonDecreasing(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		
		if (!it.hasNext()) {
            return true; // Lista vazia � considerada n�o decrescente
        }
		
		int previous = it.next(); //pegamos o primeiro elemento aqui
		while(it.hasNext()) {
			int currentValue = it.next();
			if(currentValue < previous) return false;
			previous = currentValue;
		}
		return true;
	}
}
