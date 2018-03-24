package com.jcolby.sse554.p3;

public class Launcher {

	public static void main(String[] args) {

		String nodeFile_ = new String("NodeList1.txt");
		String edgeFile_ = new String("EdgeList1.txt");
		
		Graph graph_ = new Graph(nodeFile_, edgeFile_);
		System.out.println("Graph from files:");
		
		graph_ = DijkstraPathFinder.calculateShortestPathFromSource(graph_, "H");
		graph_.print();
		
	}
}
