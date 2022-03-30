package a210802;

class StaticTest1 {
	
	int a;
	static String s;
	public static void main(String[] args) {
		s = "자바의 꿈";
		StaticTest1 st1 = new StaticTest1();
		
		//a = 1000; // 오류
		st1.a = 1000;
		System.out.println("s : " + s);
	}

}
