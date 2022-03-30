package a210810;

import java.awt.*;

public class ListEx {
	
	public static void main(String[] args) {
		Frame f = new Frame("List Test");
		Panel p = new Panel();
		
		List list1 = new List(3, true);
		
		list1.add("서울");
		list1.add("대전");
		list1.add("대구");
		list1.add("부산");
		
		p.add(list1);
		
		f.add(p);
		
		f.setSize(300, 200);
		f.setVisible(true);
	}

}
