package questao1.test;

import questao1.impl.FactoryConcreta;
import questao1.interfaces.*;

public class Main1 {
	
	static Colecao montarColecao(Factory f) {
		Colecao c1 = f. createColecao("Tema 1");
		Colecao c2 = f. createColecao("Tema 1.1");
		Colecao c3 = f. createColecao("Tema 1.2");
		Livro l1 = f. createLivro("Um livro", "Autor 1", 100);
		Livro l2 = f. createLivro("Outro livro", "Autor 2", 150);
		Livro l3 = f. createLivro("Mais um livro", "Autor 2", 140);
		Livro l4 = f. createLivro("Mais outro livro", "Autor 3", 80);
		c1.add(l1);
		c1.add(c2);
		c2.add(l2);
		c2.add(l3);
		c1.add(c3);
		c3.add(l4);
		return c1;
	}

	public static void main(String[] args) {
		Factory f = new FactoryConcreta();
		Colecao c1 = montarColecao(f);
		
		PrintVisitor pv = new PrintVisitor();
		c1.accept(pv);
	}

}
