package a210806;

class Me{
	int var = 100;
	public final void setVar(int var) {
		this.var = var;
	}
}

class MeEx extends Me{
	/*
	public void setVar(int var){
		this.var = var;
	}
	*/
	public static void main(String[] args) {
		MeEx me = new MeEx();
		me.setVar(1000);
		System.out.println(me.var);
	}

}
