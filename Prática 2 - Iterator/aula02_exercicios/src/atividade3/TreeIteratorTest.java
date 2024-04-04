package atividade3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import atividade3.impl.TreeConcrete;
import atividade3.interfaces.TreeIterator;
import atividade3.impl.PreOrderIt;

class TreeIteratorTest {

	@Test
	void test1() {
		TreeConcrete t1 = new TreeConcrete(77);
		TreeConcrete t2 = new TreeConcrete(9);
		TreeConcrete t3 = new TreeConcrete(40);
		TreeConcrete t4 = new TreeConcrete(50);
		TreeConcrete t5 = new TreeConcrete(60);
		TreeConcrete t6 = new TreeConcrete(80);
		TreeConcrete t7 = new TreeConcrete(30);
		TreeConcrete t8 = new TreeConcrete(10);
		t6.addChild(t1);
		t6.addChild(t2);
		t7.addChild(t3);
		t7.addChild(t4);
		t7.addChild(t5);
		t8.addChild(t6);
		t8.addChild(t7);
		
		TreeIterator it = new PreOrderIt(t8);
		assertTrue(it.hasNext());
		assertEquals(10, it.next().getValue());
		assertEquals(80, it.next().getValue());
		assertEquals(77, it.next().getValue());
		assertEquals(9, it.next().getValue());
		assertEquals(30, it.next().getValue());
		assertEquals(40, it.next().getValue());
		assertEquals(50, it.next().getValue());
		assertEquals(60, it.next().getValue());
		assertFalse(it.hasNext());
	}

}
