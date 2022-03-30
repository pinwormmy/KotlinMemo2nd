package a210806;

class Parent1{ // 다른 클래스 파일에 이름 겹쳐서 1붙임
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
