
public class Account {
	// fields
	private String ownerName;
	private double balance = 0;
	private int accountNumber;
	protected static int NoOfAccounts;

	// construction
	public Account(String name) {
		this.ownerName = name;

	}

	// setters and getters
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	// method for fund

	public void fund(Double amount) {
		if (amount <= 0) {
			System.out.println("not enought money to deposit");
		} else {
			balance += amount;

			;
		}

	}

	// withdraw Method

	public boolean withdraw(double amount) {
		if (amount >= balance) {
			System.out.println("insuffient");
			return false;
		} else {
			balance -= amount;
			return true;
		}

	}

// generate to string
	@Override
	public String toString() {
		return "Account [ownerName=" + ownerName + ", balance=" + balance + ", accountNumber=" + accountNumber
				+ ", NoOfAccounts=" + NoOfAccounts + "]";
	}

// generate equals
	// @Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Account other = (Account) obj;
//		if (NoOfAccounts != other.NoOfAccounts)
//			return false;
//		if (accountNumber != other.accountNumber)
//			return false;
//		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
//			return false;
//		if (ownerName == null) {
//			if (other.ownerName != null)
//				return false;
//		} else if (!ownerName.equals(other.ownerName))
//			return false;
//		return true;
//	}

}
