package a210819;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;

public class JToolBarEx extends JFrame{
	
	public JToolBarEx() {
		super("���� �׽�Ʈ");
		
		JToolBar tbar = new JToolBar("����");
		tbar.setMargin(new Insets(5,5,5,5));
		
		JPanel p = new JPanel(new GridLayout(1,0));
		
		JButton bt1 = new JButton("Java");
		JButton bt2 = new JButton("Windows");
		JButton bt3 = new JButton("Motif");
		
		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		
		tbar.add(p);
		
		add("North", tbar);
		
		setBounds(300,300,300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JToolBarEx();
	}

}
