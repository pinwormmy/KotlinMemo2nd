package a210816;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameEx extends JFrame{
	
	public JFrameEx() {
		super("JFrame Test");
		
		JButton bt1 = new JButton("Hello Swing North");
		JButton bt2 = new JButton("Hello Swing Center");
		Container cp = getContentPane();
		
		cp.add("North", bt1); 
		//cp.add(BorderLayout.NORTH, bt1);
		add(bt2);
		
		setSize(200,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public static void main(String[] args) {
		new JFrameEx();
	}
	

}
