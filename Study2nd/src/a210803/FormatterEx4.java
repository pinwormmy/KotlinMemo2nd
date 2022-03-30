package a210803;

import java.util.*;

class FormatterEx4 {
	public static void main(String[] args) {
		Formatter f = new Formatter();
		f.format("e:%1$5.1e%n", 3.14f);
		f.format("f:%1$5.1f%n", 3.15);
		f.format("g:%1$5.1g%n", new Float(3.55));
		f.format("a:%1$5.1a", 3.15);
		System.out.println(f.toString());
	}

}
