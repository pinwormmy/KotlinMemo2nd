package a210803;

class WrapperEx1 {
	public static void main(String[] args) {
		boolean b = true;
		@SuppressWarnings("deprecation")
		Boolean wrap_b = new Boolean(b);
		System.out.println("���ڿ��� �� : " + wrap_b.toString());
		
		char c = 'A';
		Character wrap_c = new Character(c);
		System.out.println("���� �� : " + wrap_c.charValue());
		
		Integer wrap_i = new Integer("10000");
		int i = wrap_i.intValue();
		System.out.println("���� �� : " + i);
		
		double d = 3.14;
		Float wrap_f = new Float(d);
		float f = wrap_f.floatValue();
		System.out.println("�Ǽ� �� : " + f);
		
		System.out.println("������ �Ǽ��� ���� �� : " + (i+f));
	}

}
