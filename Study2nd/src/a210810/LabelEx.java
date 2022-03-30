package a210810;

import java.awt.*;

public class LabelEx {
	public static void main(String[] args) {
		Frame f = new Frame("Label Test");
		Panel p = new Panel();
		
		Label label1 = new Label("�������̺�1");
		Label label2 = new Label("�������̺�2", Label.CENTER);
		Label label3 = new Label("�������̺�3", Label.LEFT);
		Label label4 = new Label("�������̺�4", Label.RIGHT);
		
		label1.setBackground(Color.green);
		label2.setBackground(Color.red);
		label3.setBackground(Color.black);
		label4.setBackground(Color.pink);
		
		p.add(label1);
		p.add(label2);
		p.add(label3);
		p.add(label4);
		
		f.add(p);
		
		f.setSize(500, 200);
		f.setVisible(true);
	}

}
