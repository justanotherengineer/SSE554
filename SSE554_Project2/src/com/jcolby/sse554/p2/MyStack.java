package com.jcolby.sse554.p2;

import java.lang.reflect.Array;

public class MyStack<T> {
	
	private T[] stack;
	private int top, stack_size;

	public MyStack(Class<T> c, int size) {
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) Array.newInstance(c, this.stack_size = size);
		this.stack = tmp;
		this.top = -1;
	}

	public Boolean isEmpty() {
		return(this.top < 0);
	}

	public Boolean isFull() {
		return(this.top >= this.stack_size-1);
	}

	public T pop() {
		if(this.isEmpty()) {
			System.out.println("Stack Underflow");
			return null;
		}
		else {
			T popped_value = this.stack[top];
			--this.top;
			return popped_value;
		}
	}

	public Boolean push(T value) {
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

	public T peek() {
		if(this.isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		else {
			return this.stack[this.top];
		}
	}
}
