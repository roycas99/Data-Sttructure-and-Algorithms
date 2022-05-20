
public class McDonald {
	// variables
	private int storeNumber;
	private double annualEarnings;

	// Constructor without parameters

	public McDonald() {
		storeNumber = 1;
		annualEarnings = 0;
	}
	
	// we can have constructors with same name as long as they have different parameters
	
	public McDonald(int sn, double ae) {
		storeNumber =sn;
		annualEarnings=ae;
	}

}
