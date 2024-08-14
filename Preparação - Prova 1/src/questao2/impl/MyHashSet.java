package questao2.impl;
import java.util.Iterator;
import java.util.LinkedList;

import questao2.interfaces.Set;

public class MyHashSet<T> implements Set<T> {
	
	private static final int NUMBUCKETS = 10;
    private LinkedList<T>[] table;
    private int size;
    
    @SuppressWarnings("unchecked")
    public MyHashSet() {
    	table = (LinkedList<T>[]) new LinkedList[NUMBUCKETS];
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }
    
    private int hash(T key) {
        return key == null ? 0 : Math.abs(key.hashCode() % table.length);
    }
    
	@Override
    public void add(T element) {
        int index = hash(element);
        LinkedList<T> bucket = table[index];
        if (!bucket.contains(element)) {
            bucket.add(element);
            size++;
        }
    }
    
	@Override
    public boolean contains(T element) {
        int index = hash(element);
        LinkedList<T> bucket = table[index];
        return bucket.contains(element);
    }
    
	@Override
    public boolean isEmpty() {
        return size == 0;
    }
    
	@Override
    public int size() {
        return size;
    }

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}
	
	// Sendo MyIterator uma classe interna a MyHashSet,
	// pode acessar os membros de MyHashSet
	private class MyIterator implements Iterator<T> {
		
		private int numBucket;
		private Iterator<T> curIterator;
		
		public MyIterator() {
			// inicia posicionando na primeira célula da tabela hash
			// que contenha ao menos um elemento
			numBucket = 0;
			while(numBucket < NUMBUCKETS) {
				curIterator = table[numBucket].iterator();
				if (curIterator.hasNext()) {
					break;
				}
				++numBucket;
			}
		}
		
		@Override
		public boolean hasNext() {
			if (numBucket >= NUMBUCKETS) {
				return false;
			}
			while(true) {
				if (curIterator.hasNext()) {
					return true;
				}
				++numBucket;
				if (numBucket == NUMBUCKETS) {
					return false;
				}
				curIterator = table[numBucket].iterator(); 
			}
		}

		@Override
		public T next() {
			return curIterator.next();
		}
		
	}
    
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < table.length; ++i) {
			s += "  " + i + ": " + table[i].toString() + "\n";
		}
		return s;
	}
}
