package com.jcolby.sse554.p2;

public class IntStack {
	
	private int [] stack;
	
	
	private int top, stack_size;
	
	public IntStack(int size) {
		this.stack_size = size;
		this.stack = new int[size];
		this.top = -1;
	}

	public Boolean isEmpty() {
		return(this.top < 0);
	}
	
	public Boolean isFull() {
		return(this.top >= this.stack_size-1);
	}
	
	public int pop() {
		if(this.isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		}
		else {
			int popped_value = this.stack[top];
			--this.top;
			return popped_value;
		}
	}
	
	public Boolean push(int value) {
		if(this.isFull()) {
			System.out.println("Stack Overflow");
			return false;
		}
		else {
			++this.top;
			this.stack[this.top] = value;
			return true;
		}
	}
	
	public int peek() {
		if(this.isEmpty()) {
			System.out.println("Stack is Empty");
			return 0;
		}
		else {
			return this.stack[this.top];
		}
	}
}
