package a210806;

interface InterTest{
	static final int A = 100;
	abstract int getA(); // abstract 예약어는 생략 가능
}

public class InterTestEx implements InterTest {
	public int getA() {
		return A;
	}
	
	public static void main(String[] args) {
		InterTestEx it1 = new InterTestEx();
		System.out.println("getA(): " + it1.getA());
	}

}
