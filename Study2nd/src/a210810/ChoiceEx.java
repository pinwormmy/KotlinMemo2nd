package a210810;

import java.awt.*;

public class ChoiceEx {
	public static void main(String[] args) {
		Frame f = new Frame("Choice Test");
		Panel p = new Panel();
		
		Choice ch = new Choice();
		
		ch.addItem("���");
		ch.addItem("����");
		ch.addItem("��");
		ch.addItem("�ٳ���");
		
		p.add(ch);
		f.add(p);
		
		f.setSize(450, 100);
		f.setVisible(true);
	}
}
