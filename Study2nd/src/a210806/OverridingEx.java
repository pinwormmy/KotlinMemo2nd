package a210806;

class Parent{
	String msg = "Parent 클래스";
	public String getMsg() {
		return msg;
	}
}

class Child extends Parent{
	String msg = "Child 클래스";
	public String getMsg() {
		return msg;
	}
}

public class OverridingEx {
	public static void main(String[] args) {
		Child cd = new Child();
		System.out.println("cd : " + cd.getMsg());
		
		Parent pt = new Child();
		System.out.println("pt : " + pt.getMsg());
	}

}
