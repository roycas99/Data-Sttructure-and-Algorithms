import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class DelivD {

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	// Constructor - DO NOT MODIFY
	public DelivD(File in, Graph gr) {
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

		// Calls the method that will do the work of deliverable D
		runDelivD();

		output.flush();
	}

	// *********************************************************************************
	// This is where your work starts

	private void runDelivD() {
		// sort nodes by their values
		NodeSorted ns = new NodeSorted();
		Collections.sort(graph.getNodeList(), ns);
		int size = graph.getNodeList().size();
		

		int i = size - 1; // final index
		int j = size - 2; // before final index
		
		// last city
		// before last city
		System.out.println(graph.getNodeList().get(i));
		System.out.println(graph.getNodeList().get(j));
		
		System.out.println(dist(graph.getNodeList().get(i),graph.getNodeList().get(j)));

		System.out.println(bitonic(i, j));

	} // end of runDelivD method

	// Bitonic method

	public int bitonic(int i, int j) {

		// base case: if we only have 2 point(i,j) then we return their distance
		if (i == 0 && j == 1) {
			return dist(graph.getNodeList().get(i), graph.getNodeList().get(j));
		}

		// second case if i is less than j-1
		else if (i < j - 1) {

			return bitonic(i, j - 1) + dist(graph.getNodeList().get(j), graph.getNodeList().get(j - 1));

		}
		// third case if i and j are equal or i = j-1
		else {
			for (int k = 0; k < j - 1; k++) {
				int min=Integer.MAX_VALUE;
				int temp=(bitonic(k, j - 1) + dist(graph.getNodeList().get(k), graph.getNodeList().get(j)));
				if(temp < min) {
				min= temp;
				return min;
				}
			}
		}
		// test
		return 2;

	} // end of Bitonic_Travel

	// distance method between 2 nodes
	public int dist(Node p, Node p2) {
		int f = 0;
		for (Edge e : p.getOutgoingEdges()) {
			if (e.getHead().equals(p2)) {
				return f = e.getDistance();
			}
		}

		return f;

	} // end of distance method

} // end of DelivC class
