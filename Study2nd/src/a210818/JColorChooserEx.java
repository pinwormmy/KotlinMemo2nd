package a210818;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class JColorChooserEx extends JFrame implements ActionListener{
	
	JMenuBar mb;
	JMenu mnuselect;
	JMenuItem mnucolor;
	JLabel l;
	JTextArea ta;
	
	public JColorChooserEx() {
		super("JColorChooser Test");
		mb = new JMenuBar();
		mnuselect = new JMenu("선택");
		mnucolor = new JMenuItem("색상");
		l = new JLabel("출력장");
		ta = new JTextArea();
		mnuselect.add(mnucolor);
		
		mb.add(mnuselect);
		
		setJMenuBar(mb);
		
		add("North", l);
		add("Center", ta);
		
		setBounds(300,300,300,200);
		setVisible(true);
		
		mnucolor.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mnucolor) {
			JColorChooser chooser = new JColorChooser();
			Color col = chooser.showDialog(this, "색상을 고르세요.", Color.blue);
			l.setText("선택한 색상은" + col);
			ta.setBackground(col);
		}
	}
	
	public static void main(String[] args) {
		new JColorChooserEx();
	}
}
