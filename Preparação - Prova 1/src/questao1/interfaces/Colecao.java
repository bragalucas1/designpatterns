package questao1.interfaces;

public interface Colecao
extends Item, Iterable<Item>
{
	void add(Item item); // adiciona item
}
