package atividade2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

class ItFunctionsTest {

	@Test
	void test_findMax() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(6);
		list.add(-2);
		list.add(18);
		list.add(0);
		int m = ItFunctions.findMax(list);
		assertEquals(18, m);
	}
	
	@Test
	void test_numOccurrences() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(13);
		list.add(6);
		list.add(-2);
		list.add(6);
		list.add(0);
		list.add(6);
		assertEquals(3, ItFunctions.numOccurences(list, 6));
		assertEquals(1, ItFunctions.numOccurences(list, -2));
		assertEquals(0, ItFunctions.numOccurences(list, 10));
	}
	
	@Test
	void test_isNonDecreasing() {
		List<Integer> list = new ArrayList<Integer>();
		assertTrue(ItFunctions.isNonDecreasing(list));
		list.add(-2);
		assertTrue(ItFunctions.isNonDecreasing(list));
		list.add(-2);
		assertTrue(ItFunctions.isNonDecreasing(list));
		list.add(0);
		list.add(6);
		list.add(13);
		assertTrue(ItFunctions.isNonDecreasing(list));
		list.add(12);
		assertFalse(ItFunctions.isNonDecreasing(list));		
	}

}
