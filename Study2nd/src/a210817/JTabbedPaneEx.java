package a210817;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTabbedPaneEx extends JFrame{
	
	ImageIcon icon1, icon2, tabicon;
	JButton b1, b2;
	JTabbedPane jp;
	
	public JTabbedPaneEx() {
		super("JTabbedPane Test");
		
		icon1 = new ImageIcon("C:/Users/erl/Pictures/pacman.jpg");
		icon2 = new ImageIcon("C:/Users/erl/Pictures/youtubeIcon.jpg");
		
		tabicon = new ImageIcon("C:/Users/erl/Pictures/twitterIcon.jpg");
		
		b1 = new JButton("»çÁø1", icon1);
		b2 = new JButton("»çÁø2", icon2);
		
		jp = new JTabbedPane();
		
		jp.addTab("ÅÇ1", new ImageIcon(" "), b1);
		jp.addTab("ÅÇ2", new JPanel().add(new JTextArea(7,20)));
		jp.addTab("ÅÇ3", tabicon, b2, "ÅÇ»çÁøµµ Ãß°¡Çß½À´Ï´Ù.");
		
		add(jp);
		
		setBounds(300,300,300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTabbedPaneEx();
	}

}
