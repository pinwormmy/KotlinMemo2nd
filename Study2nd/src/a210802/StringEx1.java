package a210802;

class StringEx1 {
	
	public static void main(String[] args) {
		String s1 = "Twinkle";
		String s2 = "Twinkle";
		if(s1 == s2)
			System.out.println("s1�� s2�� ����.");
		else
			System.out.println("s1�� s2�� ���� �ʴ�");
		
		String s3 = new String("Little Star");
		String s4 = new String("Little Star");
		if(s3 == s4)
			System.out.println("s3�� s4�� ����.");
		else
			System.out.println("s3�� s4�� ���� �ʴ�.");
	}

}