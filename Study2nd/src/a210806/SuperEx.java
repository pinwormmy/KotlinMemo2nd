package a210806;

class Parent1{ // �ٸ� Ŭ���� ���Ͽ� �̸� ���ļ� 1����
	public Parent1(int var) {
		System.out.println("Parent Class");
	}
}

public class SuperEx extends Parent1{
	public SuperEx() {
		super(1);
		System.out.println("SueprEx Class");
	}
	
	public static void main(String[] args) {
		SuperEx se = new SuperEx();
	}

}
