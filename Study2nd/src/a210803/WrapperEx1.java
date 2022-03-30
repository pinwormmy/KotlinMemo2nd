package a210803;

class WrapperEx1 {
	public static void main(String[] args) {
		boolean b = true;
		@SuppressWarnings("deprecation")
		Boolean wrap_b = new Boolean(b);
		System.out.println("문자열의 값 : " + wrap_b.toString());
		
		char c = 'A';
		Character wrap_c = new Character(c);
		System.out.println("문자 값 : " + wrap_c.charValue());
		
		Integer wrap_i = new Integer("10000");
		int i = wrap_i.intValue();
		System.out.println("정수 값 : " + i);
		
		double d = 3.14;
		Float wrap_f = new Float(d);
		float f = wrap_f.floatValue();
		System.out.println("실수 값 : " + f);
		
		System.out.println("정수와 실수의 연산 값 : " + (i+f));
	}

}
