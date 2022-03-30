package a210811;

import java.awt.*;
import java.awt.event.*;

public class MouseMotionEventEx extends Frame implements ActionListener, MouseMotionListener{
	
	Label move = new Label("마우스 따라 다니기", Label.CENTER);
	Button exit = new Button("종료");
	
	public MouseMotionEventEx() {
		setTitle("MouseMotionEvent Test");
		
		setLayout(null);
		
		move.setBounds(100,50,150,20);
		exit.setBounds(250,500,50,20);
		
		move.setBackground(Color.red);
		
		add(move);
		add(exit);
		
		setBounds(300,100,500,600);
		setVisible(true);
		
		exit.addActionListener(this);
		addMouseMotionListener(this);
	}
	
	public static void main(String[] args) {
		new MouseMotionEventEx();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	public void mouseMoved(MouseEvent e) {
		Point p = e.getPoint();
		move.setLocation(p);
	}
	
	public void mouseDragged(MouseEvent e) {}

}
