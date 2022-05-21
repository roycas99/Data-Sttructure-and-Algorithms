import java.util.Scanner;

public class AccountDriver {

	public static void main(String[] args) {
		
		// account class

				// initiate and declare scanner
				Scanner myScanner = new Scanner(System.in);

				// lets read user input and store variable

				String ownerName = myScanner.nextLine();
				System.out.println(ownerName);

				// declare and instantiate an Account Object;

				Account myAccount = new Account(ownerName);
				// static variable
				Account.NoOfAccounts = 4;
				
				// fund method
				//myAccount.fund(1000.0);
				
				
				// print the object
				System.out.println(myAccount.toString());

				// close the scanner
				myScanner.close();
	}

}
