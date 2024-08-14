package questao1.impl;

import questao1.interfaces.Livro;
import questao1.interfaces.Visitor;

public class LivroConcreto
extends ItemConcreto
implements Livro {
	
	private String autor;
	private int numPaginas;

	public LivroConcreto(String nome, String autor, int numPaginas) {
		super(nome);
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
