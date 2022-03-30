package a210802;

class StringEx4 {
	
	public static void main(String[] args) {
		String s1 = "Kim Han Eol";
		String s2 = new String("KIM HAN EOL");
		String msg = null;
		
		if(s1.equals(s2))
			msg = "s1과 s2는 내용이 같다.";
		else
			msg = "s1과 s2는 내용이 다르다.";
		System.out.println(msg);
		
		if(s1.equalsIgnoreCase(s2))
			msg = "s1과 s2는 대/소문자 구분 안 하면 같다.";
		else
			msg = "s1과 s2는 대/소문자 구분 안 해도 다르다.";
		System.out.println(msg);
		
		// format 형식에 맞춰 String 객체 생성
		
		msg = String.format("%15s, %s", s1, s2);
		System.out.println("msg : " + msg);
		
	}

}
