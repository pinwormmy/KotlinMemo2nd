package a210731;

class MethodEx2 {
	
	int var;
	
	public void setInt(int var) {
		var = var;
	}
	
	public int getInt() {
		return var;
	}
	
	public static void main(String[] args) {
		MethodEx2 me2 = new MethodEx2();
		me2.setInt(1000);
		System.out.println("var : " + me2.getInt());
	}

}
