package a210803;

import java.util.*;

class FormatterEx5 {
	
	public static void main(String[] args) {
		Formatter f = new Formatter();
		Calendar now = Calendar.getInstance();
		f.format("%1$tH:%1$tM:%1$tS%n", now);
		f.format("%1$tH:%1$tM:%1$tS %1$tp%n", now);
		f.format("%1$tY��%1$tm��%1$td��%n", now);
		f.format("%1$tY-%1$tm-%1$td,%1$tA ����%tj��°%n", now);
		System.out.println(f.toString());
	}
}
