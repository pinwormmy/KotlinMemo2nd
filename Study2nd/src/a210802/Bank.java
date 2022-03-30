package a210802;

public class Bank {
	
	private String point; // 은행 위치
	static float interest; // 은행 이자
	
	public Bank(String point) {
		this.point = point;
	}
	
	// 결과를 출력할 메소드
	
	public void getInfo() {
		System.out.println("지점 : " + point);
		System.out.println("이자율 : " + interest);
	}

}
