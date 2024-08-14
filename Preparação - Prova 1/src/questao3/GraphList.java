package questao3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphList {
	
	private List<Integer> [] adjacents;

	public GraphList(int numVertices) {
		adjacents = (List<Integer> []) new List[numVertices];
		for(int i = 0; i < numVertices; ++i) {
			adjacents[i] = new ArrayList<Integer>();
		}
	}
	
	public int numVertices() {
		return adjacents.length;
	}

	public void addEdge(int origin, int destination) {
		adjacents[origin].add(destination);
	}
	
	Iterator<Integer> iteratorVertex(int origin) {
		return adjacents[origin].iterator();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < adjacents.length; ++i) {
			s += i + ": " + adjacents[i].toString() + "\n";
		}
		return s;
	}

}
