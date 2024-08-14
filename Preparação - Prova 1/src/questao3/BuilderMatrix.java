package questao3;

public class BuilderMatrix implements BuilderInterface {
	
	private GraphMatrix matrix;
	
	@Override
	public void initGraph(int numVertices) {
		matrix = new GraphMatrix(numVertices);
	}

	@Override
	public void buildEdge(int origin, int destination) {
		matrix.addEdge(origin, destination);
	}
	
	public GraphMatrix getResult() {
		return matrix;
	}

}
