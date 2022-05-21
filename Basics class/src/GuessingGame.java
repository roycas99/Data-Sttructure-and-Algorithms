import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int r = rd.nextInt(2);  // range between 0 inclusive and 2 exclusive
		System.out.println(r);

		System.out.println("enter a number");
		int userGuess = sc.nextInt();

		while (userGuess != r) {

			System.out.println("guess again");
			userGuess = sc.nextInt();

		}

		sc.close();

	}// end of main

}
