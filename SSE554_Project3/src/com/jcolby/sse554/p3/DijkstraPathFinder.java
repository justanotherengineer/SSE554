package com.jcolby.sse554.p3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.jcolby.sse554.p3.Graph.NodeNotFoundException;

import java.util.Map.Entry;

public class DijkstraPathFinder {
	
	public DijkstraPathFinder() {
		
	}
		
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);
     
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
     
        unsettledNodes.add(source); 
     
        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry<Node, Integer> adjacencyPair: 
              currentNode.adjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
    		    Integer sourceDistance = sourceNode.distance();
    		    if (sourceDistance + edgeWeight < evaluationNode.distance()) {
    		        evaluationNode.setDistance(sourceDistance + edgeWeight);
    		        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.shortestPath());
    		        shortestPath.add(sourceNode);
    		        evaluationNode.setShortestPath(shortestPath);
    		    }
    		}

	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.distance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}

	public static Graph calculateShortestPathFromSource(Graph graph, String sourceName) {
		
		Node source = null;
		try {
			source = graph.findNodeByName(sourceName);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		source.setDistance(0);
	     
        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();
     
        unsettledNodes.add(source); 
     
        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry<Node, Integer> adjacencyPair: 
              currentNode.adjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
	}  
}
