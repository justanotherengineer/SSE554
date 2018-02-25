package com.jcolby.sse554.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntStackTest {
	
	IntStack test_stack;
	
	@BeforeEach
	void setUp() throws Exception {
		test_stack = new IntStack(3);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_stack = null;
	}

	@Test
	void testCanInstantiateIntStack() {
		IntStack stack = new IntStack(10);
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
		assertEquals(0, test_stack.pop());
		test_stack.push(10);
		assertEquals(10, test_stack.pop());
		test_stack.push(7);
		assertEquals(7, test_stack.pop());
		assertEquals(0, test_stack.pop());
	}

	@Test
	void testPush() {
		test_stack.push(10);
		assertEquals(10, test_stack.pop());
		test_stack.push(7);
		assertEquals(7, test_stack.pop());
		assertEquals(0, test_stack.pop());
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
		assertEquals(0, test_stack.pop());
	}
	
	@Test
	void testPeek() {
		assertEquals(0, test_stack.peek());
		test_stack.push(10);
		assertEquals(10, test_stack.peek());
	}

}
