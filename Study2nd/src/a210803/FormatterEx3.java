package a210803;

import java.util.*;

class FormatterEx3 {
	
	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("d:%1$5d%no:%1$5o%nx:%1$5x", 65);
		System.out.println(f.toString());
	}
}
