package a210810;

import java.awt.*;

public class ChoiceEx {
	public static void main(String[] args) {
		Frame f = new Frame("Choice Test");
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.addItem("사과");
		ch.addItem("딸기");
		ch.addItem("배");
		ch.addItem("바나나");
		
		p.add(ch);
		f.add(p);
		
		f.setSize(450, 100);
		f.setVisible(true);
	}
}
