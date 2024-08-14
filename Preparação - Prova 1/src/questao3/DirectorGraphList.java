package questao3;

import java.util.Iterator;

public class DirectorGraphList {
	
	private GraphList graphList;
	
	public DirectorGraphList(GraphList graphList) {
		this.graphList = graphList;
	}
	
	public void construct(BuilderInterface builder) {
		builder.initGraph(graphList.numVertices());
		for(int i = 0; i < graphList.numVertices(); ++i) {
			Iterator<Integer> it = graphList.iteratorVertex(i);
			while(it.hasNext()) {
				int destination = it.next();
				builder.buildEdge(i, destination);
			}
		}
	}
	
}
