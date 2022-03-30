package a210804;

public class AutoboxingEx1 {
	
	Integer var;
	public void setInt(int i) {
		var=i;
	}
	public Integer getInt() {
		return var;
	}
	
	public static void main(String[] args) {
		AutoboxingEx1 a1 = new AutoboxingEx1();
		a1.setInt(10000);
		int res = a1.getInt();
		System.out.println("res : " + res);
	}

}
