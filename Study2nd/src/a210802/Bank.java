package a210802;

public class Bank {
	
	private String point; // ���� ��ġ
	static float interest; // ���� ����
	
	public Bank(String point) {
		this.point = point;
	}
	
	// ����� ����� �޼ҵ�
	
	public void getInfo() {
		System.out.println("���� : " + point);
		System.out.println("������ : " + interest);
	}

}
