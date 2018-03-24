package com.jcolby.sse554.p3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeGraphTest {

	Node n1, n2, n3, n4;
	Edge e1, e2, e3, e4, e5;
	ArrayList<Node> testNodes;
	ArrayList<Edge> testEdges;
	NodeGraph testGraphFromArrays;
	NodeGraph testGraphFromFiles;
	
	String nodeTestFile = "NodeListTest.txt";
	String edgeTestFile = "EdgeListTest.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		n1 = new Node("A", "NodeA");
		n2 = new Node("B", "NodeB");
		n3 = new Node("C", "NodeC");
		n4 = new Node("D", "NodeD");
		
		e1 = new Edge(n1, n2, 5);
		e2 = new Edge(n1, n3, 17);
		e3 = new Edge(n1, n4, 19);
		e4 = new Edge(n2, n3, 10);
		e5 = new Edge(n3, n4, 3);
		
		testNodes = new ArrayList<Node>(
				Arrays.asList(n1, n2, n3, n4));
		testEdges = new ArrayList<Edge>(
				Arrays.asList(e1, e2, e3, e4, e5));
		
		testGraphFromArrays = new NodeGraph(testNodes, testEdges);
		testGraphFromFiles = new NodeGraph(nodeTestFile, edgeTestFile);
	}

	@AfterEach
	void tearDown() throws Exception {
		testNodes = null;	
		testEdges = null;
		testGraphFromArrays = null;
		testGraphFromFiles = null;
	}

	@Test
	void canInstantiateNodeGraphWithFile() {
		NodeGraph testGraph = new NodeGraph(nodeTestFile, edgeTestFile);
		assertNotNull(testGraph);
	}

	@Test
	void canInstantiateNodeGraphWithArraylists() {
		NodeGraph testGraph = new NodeGraph(testNodes, testEdges);
		assertNotNull(testGraph);
	}

	@Test
	void NodeGraphFromFileEqualsFromArray() {
		NodeGraph testGraph = new NodeGraph(nodeTestFile, edgeTestFile);
		assertEquals(testGraphFromArrays.toString(), testGraph.toString());
	}
	
	@Test
	void NodeGraphFromArrayEqualsFromFile() {
		NodeGraph testGraph = new NodeGraph(testNodes, testEdges);
		assertEquals(testGraphFromFiles.toString(), testGraph.toString());
	}
	
	@Test
	void testNodes() {
		assertEquals("[A,B,C,D]",testGraphFromFiles.nodes().toString());
	}

	@Test
	void testEdges() {
		assertEquals("[A5B,A17B,A19D,B10C,C3D]",testGraphFromFiles.edges().toString());
	}

}
