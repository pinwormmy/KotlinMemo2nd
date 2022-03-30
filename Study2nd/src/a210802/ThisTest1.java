package a210802;

class ThisTest1 {
	
	int a = 100;
	public void setA(int a) {
		this.a = a;
	}
	
	public static void main(String[] args) {
		ThisTest1 tt1 = new ThisTest1();
		tt1.setA(200);
		System.out.println(tt1.a);
	}

}
