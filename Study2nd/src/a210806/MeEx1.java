package a210806;

final class Me1{
	int var = 100;
	public void setVar(int var) {
		this.var = var;
	}
}

public class MeEx1 {
	
	public void setVar(int var) {
		//this.var = var; // 상속 안되ㅁ
	}
	
	public static void main(String[] args) {
		MeEx1 me1 = new MeEx1();
		me1.setVar(1000);
	}

}
