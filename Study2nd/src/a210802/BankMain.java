package a210802;

public class BankMain {
	
	public static void main(String[] args) {
		Bank bk1 = new Bank("����");
		Bank.interest = 0.2f;
		bk1.getInfo();
		
		System.out.println("--------------------");
		
		Bank bk2 = new Bank("�д�");
		//Bank.interest = 0.2f;
		bk2.getInfo();
	}

}
