package a210803;

import java.util.*;

class FormatterEx2 {
	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("���1:%1$5c%n���2:%1$-5c�n", 'A');
		System.out.println(f.toString());
	}

}
