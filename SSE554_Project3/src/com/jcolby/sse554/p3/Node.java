package com.jcolby.sse554.p3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Object representing nodes which can contain data.
 * Each node has a respective set of adjacent nodes, a shortestPath to a source, 
 * and a distance to a source
 */
public class Node {

	private String name_;
	private String data_;
    private List<Node> shortestPath_ = new LinkedList<>();
    private Integer distance_ = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes_ = new HashMap<>();
    
	public Node(String name, String data) {
		
		this.name_ = name;
		this.data_ = data;
		
	}
	public Node(String name) {

		this.name_ = name;
		this.data_ = null;
		
	}
 
    public void addDestination(Node destination, int distance) {
        adjacentNodes_.put(destination, distance);
    }
    
	@Override
	public String toString() {
		String s = name_;
		return s;
	}
	
	public void print() {
		System.out.println("Node: "+ name_);
		System.out.println("Distance: "+ distance_);
		System.out.println("Adjacent Node List:");
		System.out.println(adjacentNodes_.toString());
		System.out.println("Shortest Path List:");
		System.out.println(shortestPath_.toString());
	}
	
	public Map<Node, Integer> adjacentNodes(){
		return adjacentNodes_;
	}
	
	public String data() {
		return data_;
	}
	
	public void set_data(String string) {
		data_ = string;
	}
	
	public List<Node> shortestPath() {
		return shortestPath_;
	}
	
	public void setShortestPath(List<Node> shortestPath_) {
		this.shortestPath_ = shortestPath_;
	}
	
	public Integer distance() {
		return distance_;
	}
	
	public void setDistance(Integer distance_) {
		this.distance_ = distance_;
	}

}
