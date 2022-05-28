import java.util.*;

// A node of a graph for the Spring 2018 ICS 340 program

public class Node {

	private String name;
	private String value;  // The value of the Node which was stored in the value column
	private String abbrev;  // The abbreviation for the Node
	private ArrayList<Edge> outgoingEdges;  
	private ArrayList<Edge> incomingEdges;
	
	public Node(String abbreviation) {
		abbrev = abbreviation;
		value = null;
		name = null;
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
	}
	
	public String getAbbrev() {
		return abbrev;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
	
	public ArrayList<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	
	public ArrayList<Edge> getIncomingEdges() {
		return incomingEdges;
	}
	
	public void setAbbrev(String abbreviation) {
		abbrev = abbreviation;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void addOutgoingEdge(Edge e) {
		outgoingEdges.add(e);
	}
	
	public void addIncomingEdge(Edge e) {
		incomingEdges.add(e);
	}
	
}

