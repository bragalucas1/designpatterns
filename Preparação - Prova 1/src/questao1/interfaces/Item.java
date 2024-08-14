package questao1.interfaces;

public interface Item {
	
	String getNome(); // nome do item
	
	void accept(Visitor v);

}
