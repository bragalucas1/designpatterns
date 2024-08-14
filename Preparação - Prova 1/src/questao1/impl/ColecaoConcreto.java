package questao1.impl;

import java.util.ArrayList;
import java.util.Iterator;

import questao1.interfaces.Colecao;
import questao1.interfaces.Item;
import questao1.interfaces.Visitor;

public class ColecaoConcreto extends ItemConcreto implements Colecao {

	private ArrayList<Item> items;

	public ColecaoConcreto(String nome) {
		super(nome);
		items = new ArrayList<Item>();
	}

	public Iterator<Item> iterator() {
		return items.iterator();
	}

	public void add(Item item) {
		items.add(item);
	}

	public void accept(Visitor v) {
		v.visit(this);
		Iterator<Item> it = iterator();
		while (it.hasNext()) {
			it.next().accept(v);
		}
	}

}
