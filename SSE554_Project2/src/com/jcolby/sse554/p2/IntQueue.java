package com.jcolby.sse554.p2;

public class IntQueue {

	
	private int [] queue;
	
	
	private int front, rear, queue_size, max_size;
	
	public IntQueue(int size) {
		this.max_size = size;
		this.queue = new int[max_size];
		this.front = queue_size = 0;
		this.rear = 0;
		
	}

	public Boolean isEmpty() {
		return(queue_size == 0);
	}
	
	public Boolean isFull() {
		return(queue_size == max_size);
	}
	
	public Boolean enqueue(int value) {
		if(this.isFull()) {
			System.out.println("Queue Overflow");
			return false;
		}
		else {
			this.queue_size++;
			this.queue[this.rear] = value;
			this.rear= (this.rear + 1) % this.max_size;
			return true;
		}
	}
	
	public int dequeue() {
		if(this.isEmpty()) {
			System.out.println("Queue Underflow");
			return 0;
		}
		else {
			int value_dequeued = this.queue[front];
			this.queue_size--;
			this.front = (this.front + 1) % this.max_size;
			return value_dequeued;
		}
	}
	
	public int front() {
		if(this.isEmpty()) {
			System.out.println("Queue is Empty");
			return 0;
		}
		else {
			return this.queue[this.front];
		}
	}
}
