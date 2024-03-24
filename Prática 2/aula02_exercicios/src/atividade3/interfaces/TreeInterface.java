package atividade3.interfaces;

public interface TreeInterface {
	
	// valor inteiro na raiz da árvore
	int getValue();

	// número de filhos da raiz
	int getNumChildren(); //
	
	// i-ésimo filho da raiz (começa em 0)
	TreeInterface getChild(int i);
	
}
