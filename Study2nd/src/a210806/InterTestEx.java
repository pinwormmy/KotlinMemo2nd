package a210806;

interface InterTest{
	static final int A = 100;
	abstract int getA(); // abstract ������ ���� ����
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
