package questao3;

public class GraphMatrix {

	private int size;
	private byte[][] matrix;
	
	public GraphMatrix(int size) {
		this.size = size;
		matrix = new byte[size][size];
	}
	
	public int numVertices() {
		return size;
	}

	public void addEdge(int origin, int destination) {
		matrix[origin][destination] = 1;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				s += matrix[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}

}
