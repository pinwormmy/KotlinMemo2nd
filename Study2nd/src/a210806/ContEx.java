package a210806;

class Cont {	
	final int VAR = 100;
	public void setVar(int var) {
	//	VAR = var;
	}
}

class ContEx{
	public static void main(String[] args) {
		Cont ct = new Cont();
		ct.setVar(1000);
		
		System.out.println(ct.VAR);
	}
}
