package com.jcolby.sse554.p3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Organizes Nodes and Edges from respective text files into a graph of nodes.
 * Node List File should be "<Node_Name>,<Data_for_Node>\n"
 * Edge List File should be "<Node1_Name>,<Edge_Length>,<Node2_Name> \n"
 */
public class Graph {
    
	private Set<Node> nodeSet_ = new HashSet<>();
	private ArrayList<Node> nodeList_ = new ArrayList<Node>();
	
	public Graph(String nodeListFilename, String edgeListFilename) {
		buildNodeSet(nodeListFilename, edgeListFilename);
	}
 
    
	/**
	 * Creates the Nodes with their adjacency lists and adds them to the NodeSet
	 */
	private void buildNodeSet(String nodeListFilename, String edgeListFilename) {
		parseNodes(nodeListFilename);
		parseEdges(edgeListFilename);
		for(Node n: nodeList_) {
			nodeSet_.add(n);
		}
	}
	
	/**
	 * Reads the comma separated Nodes into the array list of Nodes from a file.
	 */
	private void parseNodes(String file) {
	    
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
	    nodeList_ = (ArrayList<Node>)nodeList;
	}
	
	/**
	 * Reads the comma separated Edges into the adjacency list for the specific Node.
	 */
	private void parseEdges(String file) {
	        
	    try{
	      File input_file = new File(file);
	      InputStream input_file_stream = new FileInputStream(input_file);
	      BufferedReader reader = new BufferedReader(new InputStreamReader(input_file_stream));
	      reader.lines().forEach(mapEdges);
	      reader.close();
	      
	    } catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	    }
	    
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
	private Consumer<? super String> mapEdges = (line) -> {
		String[] p = line.split(",");
		  
		Node n1 = null, n2 = null;
		try {
			n1 = findNodeByName(p[0]);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
		int edgeLength = Integer.parseInt(p[1]);
		
		try {
			n2 = findNodeByName(p[2]);
		} catch (NodeNotFoundException e) {
			e.printStackTrace();
		}
		
	  if(n1 != null && n2 != null){
		  n1.addDestination(n2,edgeLength);
		  n2.addDestination(n1,edgeLength);
	  }
	  
	};
	
	/**
	 * Returns a Node if the name exists in private list of nodes.
	 */
	public Node findNodeByName(String name) throws NodeNotFoundException {
		Node n = nodeList_.stream().filter(node -> name.equals(node.toString())).findFirst().orElse(null);
	
		if(n == null) {
			throw new NodeNotFoundException("The node: "+ name + " Does not exist in the Node List");
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
	
	/**
	 * Prints all node names
	 */
	@Override
	public String toString() {
		String s ="";
		
		s += "Nodes: \n";
		for(Node n : nodeSet_) {
			s += n.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Prints all Nodes in the graph
	 */
	public void print() {
		System.out.println("Graph: ");
		for(Node n : nodeSet_) {
			n.print();
		}
	}
	
	
}
