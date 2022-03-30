package a210806;

abstract class AbsEx1 {

	int a = 100;
	final String str = "abstract test"; // 상수
	public String getStr() {
		return str;
	}
	// 추상 메소드는 body가 없음
	public abstract int getA();
}
