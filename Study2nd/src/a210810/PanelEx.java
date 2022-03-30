package a210810;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class PanelEx {
	public PanelEx() {
		Frame f = new Frame("Panel Test");
		Panel p = new Panel();
		
		p.setBackground(Color.red);
		f.add(p);
		
		f.setSize(400, 400);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new PanelEx();
	}

}
