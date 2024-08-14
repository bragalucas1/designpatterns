package questao1.interfaces;

public interface Factory {
	Livro createLivro(String nome, String autor, int numPaginas);
	Colecao createColecao(String nome);
}
