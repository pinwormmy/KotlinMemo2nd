package a210806;

public class LocalInner {
	int a = 100;
	public void innerTest(int k) {
		int b = 200;
		final int c = k;
		//static int d = 300; // static변수 사용 불가
		
		class Inner{
			public void getData() {
				System.out.println("int a : " + a);
				System.out.println("int b : " + b);
				System.out.println("final int c : " + c);
			}
		}
		
		Inner i = new Inner();
		i.getData();
	}
	
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		outer.innerTest(1000);
	}

}
