package a210808;

public class AssertTest1 {
	public static void main(String[] args) {
		String str = "";
		assert str.length() > 0 : "시작시 인자값 없음";
		System.out.println(str);
	}

}
