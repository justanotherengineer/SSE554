package com.jcolby.sse554.p3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DijkstraPathFinderTest {
	
	NodeGraph testGraph;
	
	String nodeTestFile = "NodeListTest.txt";
	String edgeTestFile = "EdgeListTest.txt";
	DijkstraPathFinder pf;
	
	
	@BeforeEach
	void setUp() throws Exception {
		testGraph = new NodeGraph(nodeTestFile, edgeTestFile);
		pf = new DijkstraPathFinder(testGraph);
	}

	@AfterEach
	void tearDown() throws Exception {
		testGraph = null;
		pf = null;
	}

	@Test
	void canInstantiateWithGraph() {
		DijkstraPathFinder testPF = new DijkstraPathFinder(testGraph);
		assertNotNull(testPF);
	}
	
	private void assertMinPath(String startNode, String EndNode) {
		assertEquals(length, pf.minLength("A", "Z"));
		assertEquals(path, pf.minPath("A", "Z"));
	}

}
