package a210802;

class StringEx4 {
	
	public static void main(String[] args) {
		String s1 = "Kim Han Eol";
		String s2 = new String("KIM HAN EOL");
		String msg = null;
		
		if(s1.equals(s2))
			msg = "s1�� s2�� ������ ����.";
		else
			msg = "s1�� s2�� ������ �ٸ���.";
		System.out.println(msg);
		
		if(s1.equalsIgnoreCase(s2))
			msg = "s1�� s2�� ��/�ҹ��� ���� �� �ϸ� ����.";
		else
			msg = "s1�� s2�� ��/�ҹ��� ���� �� �ص� �ٸ���.";
		System.out.println(msg);
		
		// format ���Ŀ� ���� String ��ü ����
		
		msg = String.format("%15s, %s", s1, s2);
		System.out.println("msg : " + msg);
		
	}

}
