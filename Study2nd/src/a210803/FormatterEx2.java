package a210803;

import java.util.*;

class FormatterEx2 {
	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("결과1:%1$5c%n결과2:%1$-5c쳌", 'A');
		System.out.println(f.toString());
	}

}
