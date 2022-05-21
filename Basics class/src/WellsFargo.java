
public class WellsFargo extends Account {
	private static String nameOfBank= "Wells Fargo";

	public WellsFargo( String owner) {
		super(owner);
		
		
	}// construction
	
	private  static String getNameOfBank() {
		return nameOfBank;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WellsFargo wFargo = new WellsFargo("Abshir");
		System.out.println(wFargo.getBalance());
		System.out.println(WellsFargo.nameOfBank);
		

	}// main

}
