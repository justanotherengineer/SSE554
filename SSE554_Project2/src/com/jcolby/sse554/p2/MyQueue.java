package com.jcolby.sse554.p2;

import java.lang.reflect.Array;

public class MyQueue<T> {
	
	private T[] queue;
	private int front, rear, queue_size, max_size;

	public MyQueue(Class<T> c, int size) {
		
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) Array.newInstance(c, this.max_size = size);
		this.queue = tmp;
		this.front = queue_size = 0;
		this.rear = 0;

	}

	public Boolean isEmpty() {
		return(queue_size == 0);
	}

	public Boolean isFull() {
		return(queue_size == max_size);
	}

	public Boolean enqueue(T object) {
		if(this.isFull()) {
			System.out.println("Queue Overflow");
			return false;
		}
		else {
			this.queue_size++;
			this.queue[this.rear] = object;
			this.rear= (this.rear + 1) % this.max_size;
			return true;
		}
	}

	public T dequeue() {
		if(this.isEmpty()) {
			System.out.println("Queue Underflow");
			return null;
		}
		else {
			T object_dequeued = this.queue[front];
			this.queue_size--;
			this.front = (this.front + 1) % this.max_size;
			return object_dequeued;
		}
	}

	public T front() {
		if(this.isEmpty()) {
			System.out.println("Queue is Empty");
			return null;
		}
		else {
			return this.queue[this.front];
		}
	}
}
