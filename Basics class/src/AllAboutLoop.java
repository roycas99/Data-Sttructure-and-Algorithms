
public class AllAboutLoop {

	public static void main(String[] args) {
		// for loop if you know how many times
		// while loop if u dont know

		// while loop
		int count = 0;
		while (count < 10) {
			System.out.println("it is " + count);

			// condition to stop the loop
			count += 2;

		}
		System.out.println("now let see how do while loop wroks");
		// do while loop
		do {
			System.out.println(count);
			count += 1;

		} while (count <= 12);

	}// end main

}
