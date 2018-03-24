package com.jcolby.sse554.p3;

public class Node {

	private String name_;
	private String data_;
	
	public Node(String name, String data) {
		
		this.name_ = name;
		this.data_ = data;
		
	}
	public Node(String name) {
		
		this.name_ = name;
		this.data_ = null;
		
	}
	
	public String data() {
		return data_;
	}
	
	@Override
	public String toString() {
		String s = name_;
		return s;
	}
	public void set_data(String string) {
		data_ = string;
	}

}
