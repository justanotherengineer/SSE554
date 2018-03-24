package com.jcolby.sse554.p3;

public class Node<T> {

	private String name_;
	private T data_;
	
	public Node(String name, T object) {
		
		this.name_ = name;
		this.data_ = object;
		
	}
	public Node(String name) {
		
		this.name_ = name;
		this.data_ = null;
		
	}
	
	public T data() {
		return data_;
	}
	
	@Override
	public String toString() {
		String s = name_;
		return s;
	}

}
