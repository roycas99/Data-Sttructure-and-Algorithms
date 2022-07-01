import java.util.*;

// A node of a graph for the Spring 2018 ICS 340 program

public class Node {

	private String name;
	private String value; // The value of the Node which was stored in the value column
	private String abbrev; // The abbreviation for the Node
	private ArrayList<Edge> outgoingEdges;
	private ArrayList<Edge> incomingEdges;
	// for Delivery B
	private String color;
	private Node previous;
	public int d; // discovery time
	public int f; // final time

	// for Delivery C
	public Integer key;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

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

	// all about color
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	// all about previous Node
	public void setPreviousNode(Node n) {
		this.previous = n;
	}

	public Node getPreviousNode() {
		return previous;
	}

	// tostring to format
	public String toString() {
		return name + " " + abbrev + " has outDegree " + outgoingEdges.size() + " and Indegree " + incomingEdges.size()
				+ " degree of node is " + (outgoingEdges.size() + incomingEdges.size());
	}

// to format Indegree
	public String formatIn() {
		return "Node " + abbrev + " has indegree " + incomingEdges.size();

	}

	// to format outDegree
	public String formatOut() {
		return "Node " + abbrev + " has outdegree " + outgoingEdges.size();

	}

	// to format Edges of MSP --DelivC
	public String formatMSP() {
		return abbrev;
	}

	// find edge method
	public Edge findEdge(Node n) {
		// n is parent
		for (Edge e : incomingEdges) {
			if (e.getTail().equals(n)) {
				return e;
			}

		} // end for loop

		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

// use name for equality because each node has unique name. do not use key.
	// this is important for KeyComparator class
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
