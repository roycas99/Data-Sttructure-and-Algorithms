import java.io.*;
import java.util.Collections;
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

	} // end of runDelivC

	// Priority Queue Implementation
	public static PriorityQueue<Node> Q = new PriorityQueue<Node>(); // from java.util

	public void MST_PRIM() {
		for (Node n1 : graph.getNodeList()) {
			n1.setKey(Integer.MAX_VALUE);
			n1.setPreviousNode(null);
			n1.setColor("WHITE");

		} // end of the loop
			// set key of start node to zero
		graph.startingNode().setKey(0);
		// add all vertices into Queue
		addNodeToQue();
		// while Q is not empty
		while (!Q.isEmpty()) {
			Node n3 = Q.poll();// extract-minHeap
			// for adjacent nodes

			SortedEdges s = new SortedEdges();

			for (Edge e : n3.getOutgoingEdges()) {
				// let me sort outgoing edges
				Collections.sort(n3.getOutgoingEdges(), s);
				Node v = e.getHead();

				if (Q.contains(v) && e.getDistance() < v.getKey()) {
					v.setPreviousNode(e.getTail());
					v.setKey(e.getDistance());
				}
			}
		}

	}// end of MST_PRIM

	public static void view() {
		for (Node x : Q) {
			System.out.print(x + " ");
		}
		System.out.println();
	} // end of View Method

	public void addNodeToQue() {
		graph.startingNode().setColor("BLACK");
		SortedEdges sb = new SortedEdges();
		Collections.sort(graph.startingNode().getOutgoingEdges(), sb);

		for (Edge e : graph.startingNode().getOutgoingEdges()) {

			Node v = e.getHead();

			if (v.getColor().equalsIgnoreCase("WHITE")) {

				// add to Que
				Q.add(v);
				v.setKey(e.getDistance());
				v.setColor("BlACK");

			}
			; // end of If

		} // end of for loop

	} // end of AddNode

} // end of the class
