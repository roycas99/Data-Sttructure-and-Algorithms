
public class Driver {

	public static void main(String[] args) {

		// this how to call regular function
		MethodsExamples method = new MethodsExamples();
		int result = method.subtract(2, 6);
		System.out.println(result);

		// this is how u call static function
		MethodsExamples.sum();
		
		// constructors
		
		McDonald mcDonald = new McDonald(2,500);
		System.out.println(mcDonald.toString());
		
		

	}

}
