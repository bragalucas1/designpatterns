package questao1.impl;

import questao1.interfaces.Colecao;
import questao1.interfaces.Factory;
import questao1.interfaces.Livro;

public class FactoryConcreta implements Factory {

	@Override
	public Livro createLivro(String nome, String autor, int numPaginas) {
		return new LivroConcreto(nome, autor, numPaginas);
	}

	@Override
	public Colecao createColecao(String nome) {
		return new ColecaoConcreto(nome);
	}

}
