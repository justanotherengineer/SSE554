package com.jcolby.sse554.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

	MyLinkedList<Integer> test_linkedlist;
	int test_size = 4;

	@BeforeEach
	void setUp() throws Exception {
		test_linkedlist = new MyLinkedList<Integer>(test_size);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_linkedlist = null;
	}

	@Test
	void testCanInstantiateIntQueue() {
		MyLinkedList<Integer> test = new MyLinkedList<Integer>(10);
		assertNotNull(test);	
	}

	@Test
	void testInsert() {
		for(int i = 0; i < test_size; i++) {
			assertTrue(test_linkedlist.insert(i));
		}
	}

	@Test
	void testDelete() {
		assertFalse(test_linkedlist.delete(99));
		
		for(int i = 0; i < test_size; i++) {
			test_linkedlist.insert(i);
		}
		for(int i = 0; i < test_size; i++) {
			assertTrue(test_linkedlist.delete(i));
		}
	}

}
