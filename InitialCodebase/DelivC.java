import java.io.*;

public class DelivC{

	private File inputFile;
	private File outputFile;
	private PrintWriter output;
	private Graph graph;

	//Constructor - DO NOT MODIFY
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

	//*********************************************************************************
	//               This is where your work starts
	
	private void runDelivC() {
		//Delete these lines when you add functionality
		System.out.println("DelivC:  To be implemented");//Prints to console
		output.println("DelivC:  To be implemented");//Prints to file
		
	}

}

