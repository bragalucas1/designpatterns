package questao2.test;

import java.util.Iterator;

import questao2.impl.MyHashSet;
import questao2.interfaces.Set;

public class Main2 {

	public static void test1(Set<String> set) {
		set.add("public");
		set.add("static");
		set.add("void");
		set.add("main");
		set.add("String");
		set.add("args");
		set.add("class");
		set.add("while");
		set.add("for");

		System.out.println(set.toString());

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		test1(new MyHashSet<>());
	}

}
