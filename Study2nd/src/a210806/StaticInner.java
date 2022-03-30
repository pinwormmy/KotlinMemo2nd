package a210806;

public class StaticInner {

	int a = 10;
	private int b = 100;
	static int c = 200;
	
	static class Inner{
		static int d = 1000;
		public void printData() {
			//System.out.println("int a : " + a);
			//System.out.println("private int b : " + b);
			System.out.println("static int c : " + c);
			System.out.println("static int d : " + d);
		}
	}
	public static void main(String[] args) {
		StaticInner.Inner inner = new StaticInner.Inner();
		inner.printData();
		
		//  StaticInner라는 외부 클래스 내에서 생성할 때
		//Inner inner = new Inner();
		//inner.printData();
	}
}
