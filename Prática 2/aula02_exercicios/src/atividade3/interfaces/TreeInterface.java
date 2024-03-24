package atividade3.interfaces;

public interface TreeInterface {
	
	// valor inteiro na raiz da �rvore
	int getValue();

	// n�mero de filhos da raiz
	int getNumChildren(); //
	
	// i-�simo filho da raiz (come�a em 0)
	TreeInterface getChild(int i);
	
}
