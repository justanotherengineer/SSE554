package com.jcolby.sse554.p3;

public class Launcher {

	public static void main(String[] args) {

		String nodeFile_ = new String("NodeList1.txt");
		String edgeFile_ = new String("EdgeList1.txt");
		
		NodeGraph graph_ = new NodeGraph(nodeFile_, edgeFile_);
		
		graph_.print();
		
	}
}
