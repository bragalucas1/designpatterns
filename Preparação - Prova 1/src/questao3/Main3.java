package questao3;

public class Main3 {

	public static void main(String[] args) {
		GraphList g = new GraphList(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.addEdge(3, 4);
		g.addEdge(4, 2);
		g.addEdge(4, 3);
		
		System.out.println(g.toString());
		
		DirectorGraphList director = new DirectorGraphList(g);
		BuilderMatrix builder = new BuilderMatrix();
		director.construct(builder);
		GraphMatrix g2 = builder.getResult();
		System.out.println(g2.toString());
	}

}
