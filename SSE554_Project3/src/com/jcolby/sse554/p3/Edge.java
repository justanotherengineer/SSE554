package com.jcolby.sse554.p3;

public class Edge<T> {
	private Node<T> node1_, node2_;
	private int length_;
	
	public Edge(Node<T> n1, Node<T> n2, int len){
		
		this.node1_ = n1;
		this.node2_ = n2;
		this.length_ = len;
		
	}
	
	@Override
	public String toString() {
		String s = node1_.toString() + length_ + node2_.toString();
		return s;
	}
}
