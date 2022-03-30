package a210802;

class StirngBufEx1 {
	
	public static void main(String[] args) {
		int var = 0;
		StringBuffer sb = new StringBuffer("Han-Eol");
		var = sb.capacity();
		System.out.println("capacity : " + var);
		var = sb.length();
		System.out.println("length : " + var);
	}

}
