package a210802;

class StringBufEx2 {
	
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("Han-Eol");
		StringBuffer sb2 = sb1.append(" & Lisa");
		
		String msg = null;
		if(sb1 == sb2)
			msg = "sb1와 sb2는 같다.";
		else
			msg = "sb1과 sb2는 다르다.";
		System.out.println(msg);
		msg = sb1.toString();
		System.out.println("sb1 : " + msg);
		msg = sb2.toString();
		System.out.println("sb2 : " + msg);
	}

}
