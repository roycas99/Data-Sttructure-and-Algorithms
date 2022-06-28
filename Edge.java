//import java.util.*;

// Edge between two nodes
public class Edge {

	private int distance;
	private Node tail;
	private Node head;
	private String type;

	public Edge(Node tailNode, Node headNode, int dist) {
		distance = dist;
		tail = tailNode;
		head = headNode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Node getTail() {
		return tail;
	}

	public Node getHead() {
		return head;
	}

	public int getDistance() {
		return distance;
	}

	public void setTail(Node newTail) {
		tail = newTail;
	}

	public void setHead(Node newHead) {
		head = newHead;
	}

	public void setDistance(int dist) {
		distance = dist;
	}

	// return the type of edge
	public String Type() {
		if (type != null && getType().equalsIgnoreCase("Tree")) {
			return getTail().getAbbrev() + "->" + getHead().getAbbrev() + "\t\t\t" + getType();
		}

		else if (getTail().d > getHead().d && getTail().f < getHead().f) {
			this.setType("Back");
			return getTail().getAbbrev() + "->" + getHead().getAbbrev() + "\t\t\t" + getType();
		}

		else if (getHead().d < getHead().f && getHead().f < getTail().d && getTail().d < getTail().f) {
			this.setType("Cross");
			return getTail().getAbbrev() + "->" + getHead().getAbbrev() + "\t\t\t" + getType();
		}

		else {
			this.setType("Forward");
			return getTail().getAbbrev() + "->" + getHead().getAbbrev() + "\t\t\t" + getType();

		}

	} // end of Type Method

} // end of class
