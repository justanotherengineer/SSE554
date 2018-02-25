package com.jcolby.sse554.p2;

public class Launcher {

	public static void main(String[] args) {
		
		System.out.println("\nMy Stack Example---------------------");
		MyStack<Integer> s = new MyStack<Integer>(Integer.class, 5);        
		System.out.println("\nStack size is 5");

		for(int i = 1; i < 7; i++) {
			if (s.push(i)) {
				System.out.println(i+ " Pushed to stack");
			}else {
				System.out.println(i+ " Not pushed to stack");
			}
		}

		for(int i = 1; i < 7; i++) {
			System.out.println(s.pop() + " Popped from stack");
		}
		
		System.out.println("\nMy Queue Example---------------------");
		MyQueue<Integer> queue = new MyQueue<Integer>(Integer.class, 5);        

		System.out.println("\nQueue size is 5");

		for(int i = 1; i < 7; i++) {
			if (queue.enqueue(i)) {
				System.out.println(i+ " Was queued");
			}else {
				System.out.println(i+ " Was not queued");
			}
		}

		for(int i = 1; i < 7; i++) {
			Integer val = queue.dequeue();
			if(val != null) {
				System.out.println(val.toString() + " was dequeued");	
			}
		}
		System.out.println("\nMy Linked-List Example---------------------");
		System.out.println("\nBegin Linked List");
		MyLinkedList<Integer> linkedlist = new MyLinkedList<Integer>(1);
		System.out.println("Adding 1, 2, 3, 4, 5");
		linkedlist.insert(2);
		linkedlist.insert(3);
		linkedlist.insert(4);
		linkedlist.insert(5);
		System.out.println("Printing Contents");
		linkedlist.print();
		System.out.println("Deleting 3");
		linkedlist.delete(3);
		System.out.println("Printing Contents");
		linkedlist.print();
	}
}

