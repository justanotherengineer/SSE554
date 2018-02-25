package com.jcolby.sse554.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest {

	MyStack<Integer> test_stack;
	
	@BeforeEach
	void setUp() throws Exception {
		test_stack = new MyStack<Integer>(Integer.class,3);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_stack = null;
	}

	@Test
	void testCanInstantiateIntStack() {
		MyStack<Integer> stack = new MyStack<Integer>(Integer.class,10);
		assertNotNull(stack);
	}

	@Test
	void testIsEmpty() {
		assertTrue(test_stack.isEmpty());
		test_stack.push(10);
		assertFalse(test_stack.isEmpty());
		test_stack.pop();
		assertTrue(test_stack.isEmpty());
	}

	@Test
	void testIsFull() {
		assertFalse(test_stack.isFull());
		test_stack.push(10);
		test_stack.push(10);
		test_stack.push(10);
		assertTrue(test_stack.isFull());
		test_stack.pop();
		assertFalse(test_stack.isFull());
	}

	@Test
	void testPop() {
		assertNull(test_stack.pop());
		test_stack.push(10);
		assertEquals(10, test_stack.pop().intValue());
		test_stack.push(7);
		assertEquals(7, test_stack.pop().intValue());
		assertNull(test_stack.pop());
	}

	@Test
	void testPush() {
		assertTrue(test_stack.push(10));
		assertEquals(10, test_stack.pop().intValue());
		assertTrue(test_stack.push(7));
		assertEquals(7, test_stack.pop().intValue());
	}
	
	@Test
	void testOverflow() {
		test_stack.push(10);
		test_stack.push(10);
		test_stack.push(10);
		assertFalse(test_stack.push(7));
	}
	
	@Test
	void testUnderflow() {
		assertNull(test_stack.pop());
	}
	
	@Test
	void testPeek() {
		assertNull(test_stack.peek());
		test_stack.push(10);
		assertEquals(10, test_stack.peek().intValue());
	}

}
