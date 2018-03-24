package com.jcolby.sse554.p2;

public class MyLinkedList<E> {

	private Node<E> head;

	public MyLinkedList(E item) {

		head = new Node<E>(item);

	} 

	public Boolean insert(E item) {

		Node<E> n = new Node<E>(item, head);
		head = n;
		return true;

	}
	public Boolean delete(E item) {

		Node<E> current = head;
		Node<E> next = head.next_node_;
		if(current.value_ == item) {
			current.next_node_ = next;	
			return true;
		}else if(next == null) {
			return false;
		}else {
			while(true) {
				if(next.value_ == item) {
					current.next_node_ = next.next_node_;
					return true;
				}else if (next.next_node_ != null){
					current = next;
					next = next.next_node_;
				}else {
					return false;
				}
			}
		}		
	}

	public Node<E> find(E item) {

		Node<E> current = head;
		Node<E> next = head.next_node_;
		if(current.value_ == item) {
			return current;
		}else {
			while(true) {
				if(next.value_ == item) {
					return next;
				}else if (next.next_node_ != null){
					current = next;
					next = next.next_node_;
				}else {
					return null;
				}
			}
		}		
	}

	public void print() {

		Node<E> tmp = head;

		while(tmp != null) {
			System.out.println(tmp.value_.toString());
			tmp = tmp.next_node_;
		}
	}

	class Node<T>{
		T value_;
		Node<T> next_node_;

		Node(T object){
			this.value_ = object;
			next_node_ = null;
		}

		Node(T object, Node<T> next_node){
			this.value_ = object;
			this.next_node_ = next_node;
		}

	}

}
