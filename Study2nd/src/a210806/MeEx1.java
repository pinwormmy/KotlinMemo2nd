package a210806;

final class Me1{
	int var = 100;
	public void setVar(int var) {
		this.var = var;
	}
}

public class MeEx1 {
	
	public void setVar(int var) {
		//this.var = var; // ��� �ȵǤ�
	}
	
	public static void main(String[] args) {
		MeEx1 me1 = new MeEx1();
		me1.setVar(1000);
	}

}
