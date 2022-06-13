import java.io.*;
import java.util.Collections;

public class DelivB {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;
	private static int time;

	// Constructor - DO NOT MODIFY
	public DelivB(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable B
		runDelivB();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivB() {

		// format output
		System.out.println("DFS of graph");
		System.out.println();
		System.out.printf("%-22s%-22s%-22s\n", "Node", "Disc", "Finish");

		DFS(graph);

		// to print DFS of the the graph .
		for (Node n : graph.getNodeList()) {

			System.out.printf("%-22s%-22d%-22d\n", n.getAbbrev(), n.d, n.f);
		}

		// print classify Edges
		Print_Edge_classify();

	}// end of rundelivB

	// DFS Method

	public static void DFS(Graph g) {

		// Initialized: set every-node into white
		for (Node node1 : g.getNodeList()) {
			node1.setColor("WHITE");
			node1.setPreviousNode(null);
		} // end of first loop
		time = 0;
		// this is where we decided which node we gonna started our DFS visit.
		DFS_VISIT(g, g.startingNode());

		// we only do DFS_visit if node is undiscover
		for (Node node2 : g.getNodeList()) {
			if (node2.getColor().equalsIgnoreCase("WHITE")) {
				DFS_VISIT(g, node2);
			}
		} // end of second loop

	}// end of DFS

	// DFS_VISIT Method
	public static void DFS_VISIT(Graph g, Node u) {
		time++;
		u.d = time;
		u.setColor("GRAY");
		// Node v=null;
		// sorted edges before going through them
		SortedEdges sb = new SortedEdges();
		Collections.sort(u.getOutgoingEdges(), sb);

		for (Edge e : u.getOutgoingEdges()) {

			Node v = e.getHead();
			if (v.getColor().equalsIgnoreCase("WHITE")) {

				// to set type tree
				e.setType("Tree");
				v.setPreviousNode(u);

				DFS_VISIT(g, v);

			}
			; // end of If

		} // end of for loop
		u.setColor("BLACK");
		time++;
		u.f = time;

	} // end of DFS -visit

	public void Print_Edge_classify() {

		// to classify edges
		System.out.println();
		System.out.println("Edge Classification");
		System.out.println();
		System.out.printf("%-24s%-22s\n", "Edge", "Type");

		for (Edge e : graph.getEdgeList()) {

			System.out.println(e.Type());

		} // second loop

	} // end of Print Edge Method

}// end of Deliv
