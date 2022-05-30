import java.io.*;
//import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DelivA {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivA(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable A
		runDelivA();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivA() {

// incoming class
		// sort them
		Collections.sort(graph.getNodeList(), new IndegreeComparator());
		// print
		System.out.println("Indegree: ");
		for (int i = 0; i < graph.getNodeList().size(); i++) {

			System.out.println(graph.getNodeList().get(i).formatIn());
		}

		// to separate indegree and out degree print
		System.out.println();

// outgoing class

		// sort
		Collections.sort(graph.getNodeList(), new OutDegreeComparator());

		// print
		System.out.println("Outsdegree: ");
		for (int i = 0; i < graph.getNodeList().size(); i++) {
			System.out.println(graph.getNodeList().get(i).formatOut());
		}

	} // end of runDeliva

	// Private class Comparator
	private class IndegreeComparator implements Comparator<Node> {

		@Override
		public int compare(Node node1, Node node2) {
			// compare based of income
			if (node1.getIncomingEdges().size() > node2.getIncomingEdges().size()) {
				return -1; // means this one has to go first . i go before node 2
			} else if (node1.getIncomingEdges().size() < node2.getIncomingEdges().size()) {
				return 1;
			}

			// else if compare based on outgoing
			else if (node1.getOutgoingEdges().size() > node2.getOutgoingEdges().size()) {
				return -1;
			} else if (node1.getOutgoingEdges().size() < node2.getOutgoingEdges().size()) {
				return 1;
			}

			// else aphbaticall order ( abb/ name)

			else {
				return node1.getAbbrev().compareTo(node2.getAbbrev());
			}

		} // end of compare
	} // end of IndegreeComparator class

	// begin of OutDegreeComparator
	private class OutDegreeComparator implements Comparator<Node> {

		@Override
		public int compare(Node node1, Node node2) {
			// based on outgoingEdges
			if (node1.getOutgoingEdges().size() > node2.getOutgoingEdges().size()) {
				return -1;
			}

			else if (node1.getOutgoingEdges().size() < node2.getOutgoingEdges().size()) {
				return 1;
			}

			// based income
			else if (node1.getIncomingEdges().size() > node2.getIncomingEdges().size()) {
				return -1;
			} else if (node1.getIncomingEdges().size() < node2.getIncomingEdges().size()) {
				return 1;
			} else {

				return node1.getAbbrev().compareTo(node2.getAbbrev());

			}

		} // end of compare method

	} // end of outgoing class

}// end of deliv A
