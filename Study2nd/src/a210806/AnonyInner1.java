package a210806;

abstract class TestAbst{
	int data = 7474;
	public abstract void printData();
}

public class AnonyInner1 {
	
	TestAbst inn = new TestAbst() {
		public void printData() { // �̿ϼ��� ���� �ϼ�
			System.out.println("data : " + data);
		}
	};
	
	public static void main(String[] args) {
		AnonyInner1 ai = new AnonyInner1();
		ai.inn.printData();
	}
	
}
