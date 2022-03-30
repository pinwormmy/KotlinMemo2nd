package a210806;

interface TestInter{
	int data = 74;
	public void printData();
}

public class AnonyInner {
	
	public void test() {
		
		new TestInter() {
			public void printData() { // 미완성된 것을 완성함
				System.out.println("data : " + data);
			}
		}.printData();
	}
	public static void main(String[] args) {
		AnonyInner ai = new AnonyInner();
		ai.test();
		//new AnonyInner().test();
	}
}
