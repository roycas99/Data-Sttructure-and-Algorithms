import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DelivC {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivC(File in, Graph gr) {
		inputFile = in;
		graph = gr;

		// Set up for writing to a file
		try {
			// Use input file name to create output file in the same location
			String inputFileName = inputFile.toString();
			String outputFileName = inputFileName.substring(0, inputFileName.length() - 4).concat("_out.txt");
			outputFile = new File(outputFileName);

			// A Printwriter is an object that can write to a file
			output = new PrintWriter(outputFile);
		} catch (Exception x) {
			System.err.format("Exception: %s%n", x);
			System.exit(0);
		}

		// Calls the method that will do the work of deliverable C
		runDelivC();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivC() {

		MST_PRIM();

		int c = 0;
		for (Edge e : MST_PRIM()) {
			c += e.getDistance();
		}
		System.out
				.println("The minimum spanning tree has a total cost of " + c + " and includes the following edges: ");

		// Node[] node = new Node[graph.getNodeList().size()];

		for (Edge e : MST_PRIM()) {

			System.out.println(e.getHead().formatMSP() + "-" + e.getTail().formatMSP());

		}

	} // end of runDelivC

	// compares keys of the nodes
	Comparator<Node> cm = new KeyComparator();

	public ArrayList<Edge> MST_PRIM() {
		// Priority Queue Implementation
		PriorityQueue<Node> Q = new PriorityQueue<Node>(graph.getNodeList().size(), cm); // from java.util

		ArrayList<Edge> MST = new ArrayList<Edge>();
		// Initialize all the nodes in the graph
		for (Node n1 : graph.getNodeList()) {

			n1.setKey(Integer.MAX_VALUE);
			n1.setPreviousNode(null);

		} // end of the loop

		// set key of start node to zero
		graph.startingNode().setKey(0);

		// add all vertices into Queue
		for (Node n : graph.getNodeList()) {
			Q.add(n);
		}

		// while Q is not empty
		while (!Q.isEmpty()) {
			Node n3 = Q.poll();// extract-minHeap
            // add the edge into the  MST -list
			if (n3.getPreviousNode() != null) {
				Edge e = n3.findEdge(n3.getPreviousNode());
				MST.add(e);

			}

			for (Edge e : n3.getOutgoingEdges()) {
				// let me sort outgoing edges but PQ will do for us

				Node v = e.getHead();

				if (Q.contains(v) && e.getDistance() < v.getKey()) {
					Q.remove(v); // remove the node from Queue before update their key
					v.setPreviousNode(e.getTail());
					v.setKey(e.getDistance());
					Q.add(v); // add the node back to the Queue after update their key

				} // end of if

			} // end of for loop

		}

		return MST;

	}// end of MST_PRIM

} // end of the class
