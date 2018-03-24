package com.jcolby.sse554.p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Organizes Nodes and Edges from respective text files into a graph of nodes.
 * Node List File should be "<Node_Name>,<Data_for_Node>\n"
 * Edge List File should be "<Node1_Name>,<Edge_Length>,<Node2_Name> \n"
 */
public class NodeGraph {
	
	private ArrayList<Node> nodes_ = new ArrayList<Node>();
	private ArrayList<Edge> edges_ = new ArrayList<Edge>();
	
	public NodeGraph(String nodeListFileName, String edgeListFileName) {
		
		nodes_ = (ArrayList<Node>) parseNodes(nodeListFileName);
		edges_ = (ArrayList<Edge>) parseEdges(edgeListFileName);
		
	}
	
	public ArrayList<Node> nodes() {
		return nodes_;
	}
	
	public ArrayList<Edge> edges() {
		return edges_;
	}
	
	/**
	 * Prints all nodes and edges
	 */
	public void print() {
		System.out.println("Nodes: ");
		for(Node n : nodes_) {
			System.out.println(n.toString());
		}
		System.out.println("Edges: ");
		for(Edge e : edges_) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Reads the comma separated Nodes into a list of Nodes from a file.
	 */
	private List<Node> parseNodes(String file) {
	    
		List<Node> nodeList = new ArrayList<Node>();
	    
	    try{
	      File input_file = new File(file);
	      InputStream input_file_stream = new FileInputStream(input_file);
	      BufferedReader reader = new BufferedReader(new InputStreamReader(input_file_stream));
	      
	      nodeList = reader.lines()
	    		  .map(mapToNode)
	    		  .collect(Collectors.toList());
	      
	      reader.close();
	    } catch (Exception e) {
	      
	    }
	    return nodeList;
	}
	
	/**
	 * Reads the comma separated Edges into a list of edges from a file.
	 */
	private List<Edge> parseEdges(String file) {
	    
		List<Edge> edgeList = new ArrayList<Edge>();
	    
	    try{
	      File input_file = new File(file);
	      InputStream input_file_stream = new FileInputStream(input_file);
	      BufferedReader reader = new BufferedReader(new InputStreamReader(input_file_stream));
	      
	      edgeList = reader.lines()
	    		  .map(mapToEdge)
	    		  .collect(Collectors.toList());
	      
	      reader.close();
	    } catch (Exception e) {
	      
	    }
	    return edgeList;
	}
	
	/**
	 * Maps the comma separated Nodes with their data to Node objects.
	 */
	private Function<String, Node> mapToNode = (line) -> {
		String[] p = line.split(",");
		Node node = new Node(p[0],p[1]);
		return node; 
	};
	
	/**
	 * Maps the comma separated Edges to Edge objects.
	 */
	private Function<String, Edge> mapToEdge = (line) -> {
		
		String[] p = line.split(",");
		  
		Node n1 = null, n2 = null;
		try {
			n1 = findNodeByName(nodes_, p[0]);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		int edgeLength = Integer.parseInt(p[1]);
		
		try {
			n2 = findNodeByName(nodes_, p[2]);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	  if(n1 != null && n2 != null){
		  Edge edge = new Edge(n1,n2,edgeLength);			  
		  return edge;  
	  } else { 
		  return null; 
	  }
	  
	};
	
	/**
	 * Returns a Node if the name exists in private list of nodes.
	 */
	private static Node findNodeByName(ArrayList<Node> nodeList, String name) throws NodeNotFoundException {
		Node n = nodeList.stream().filter(node -> name.equals(node.toString())).findFirst().orElse(null);
	
		if(n == null) {
			throw new NodeNotFoundException("The node: "+ name + "Doest not exist in the Edge List");
		} else {
			return n;
		}
	}
	
	/**
	 * Custom exception class for Nodes.
	 */
	@SuppressWarnings("serial")
	public static class NodeNotFoundException extends Exception
	{
	  public NodeNotFoundException(String message)
	  {
	    super(message);
	  }
	}
	
}
