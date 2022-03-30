package a210803;

import java.util.*;

class FormatterEx6 {
	public static void main(String[] args) {
		Formatter f = new Formatter();
		Calendar now = Calendar.getInstance();
		f.format("%tR%n", now);
		f.format("%tT%n", now);
		f.format("%tr%n", now);
		f.format("%tD%n", now);
		f.format("%tF%n", now);
		f.format("%tc", now);
		
		System.out.println(f.toString());
	}

}
