package questao1.test;

import java.util.Iterator;

import questao1.interfaces.*;

public class PrintVisitor implements Visitor {

	private int indent;
	
	public PrintVisitor() {
		indent = 0;
	}

	public void visit(Livro livro) {
		String s = "";
		for(int i = 0; i < indent; ++i) {
			s += "    ";
		}
		System.out.println(s + "- Livro: " + livro.getNome());
		System.out.println(s + "    " + "Autor: " + livro.getAutor());
		System.out.println(s + "    " + "NumPaginas: " + livro.getNumPaginas());
	}

	public void visit(Colecao colecao) {
		String s = "";
		for(int i = 0; i < indent; ++i) {
			s += "    ";
		}
		System.out.println(s + "- Coleção: " + colecao.getNome());
		indent += 1;
		Iterator<Item> it = colecao.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			item.accept(this);
		}
		indent -= 1;
	}

}
