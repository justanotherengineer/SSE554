package com.jcolby.sse554.p2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest {

	MyQueue<Integer> test_queue;
	int test_size = 4;

	@BeforeEach
	void setUp() throws Exception {
		test_queue = new MyQueue<Integer>(Integer.class,test_size);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_queue = null;
	}

	@Test
	void testCanInstantiateIntQueue() {
		MyQueue<Integer> queue = new MyQueue<Integer>(Integer.class,10);
		assertNotNull(queue);	
	}

	@Test
	void testIsEmpty() {
		assertTrue(test_queue.isEmpty());
		test_queue.enqueue(10);
		assertFalse(test_queue.isEmpty());
		test_queue.dequeue();
		assertTrue(test_queue.isEmpty());
	}

	@Test
	void testIsFull() {
		assertFalse(test_queue.isFull());
		
		for(int i = 0; i < test_size; i++) {
			test_queue.enqueue(10);
		}
		assertTrue(test_queue.isFull());
		
		test_queue.dequeue();
		assertFalse(test_queue.isFull());
	}

	@Test
	void testEnqueue() {
		
		for(int i = 0; i < test_size; i++) {
			assertTrue(test_queue.enqueue(i));
		}
		assertFalse(test_queue.enqueue(5));
	}

	@Test
	void testDequeue() {
		
		assertNull(test_queue.dequeue());
		
		for(int i = 0; i < test_size; i++) {
			test_queue.enqueue(i);
		}
		for(int i = 0; i < test_size; i++) {
			assertEquals(i,test_queue.dequeue().intValue());
		}
		assertNull(test_queue.dequeue());
		assertNull(test_queue.dequeue());
	}

	@Test
	void testFront() {
		assertNull(test_queue.front());
		for(int i = 0; i < test_size; i++) {
			test_queue.enqueue(i);
		}
		assertEquals(0,(int)test_queue.front());
		
	}

}
