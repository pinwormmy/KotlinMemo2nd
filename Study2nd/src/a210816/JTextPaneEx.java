package a210816;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.text.*;

public class JTextPaneEx extends JFrame{
	public JTextPaneEx() {
		JTextPane textPane = createTextPane();
		JScrollPane sp = new JScrollPane(textPane);
		sp.setPreferredSize(new Dimension(250,250));
		add(sp);
		pack();
		setLocation(300,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JTextPane createTextPane() {
		String newline = "\n";
		String[] initString = 
			{ "�̰��� �Ϲ�ü �Դϴ�." + newline, "�̰��� ���Ÿ�ü �Դϴ�." + newline, 
					"�̰��� ����ü �Դϴ�." + newline, " " + newline, " " + newline
			};
		
		String[] initStyles = {
				"regular", "italic", "bold", "button", "icon"
		};
		
		JTextPane textPane = new JTextPane();
		StyledDocument sdoc = textPane.getStyledDocument();
		addStylesToDocument(sdoc);
		
		try {
			for(int i=0; i<initString.length; i++) {
				sdoc.insertString(sdoc.getLength(), initString[i], sdoc.getStyle(initStyles[i]));
			}
		}catch(Exception ble) {
			ble.printStackTrace();
		}
		return textPane;
	}
	
	protected void addStylesToDocument(StyledDocument sdoc) {
		//Initialize som styles.
		Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		Style regular = sdoc.addStyle("regular", style);
		StyleConstants.setFontFamily(style, "SansSerif");
		
		Style s = sdoc.addStyle("italic", regular);
		StyleConstants.setItalic(s, true);
		
		s = sdoc.addStyle("bold", regular);
		StyleConstants.setBold(s, true);
		
		s = sdoc.addStyle("icon", regular);
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
		ImageIcon pigIcon = new ImageIcon("C:/Users/erl/Pictures/Belle_gif.gif");
		if(pigIcon != null) {
			StyleConstants.setIcon(s, pigIcon);
		}
		s = sdoc.addStyle("button", regular);
		StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
		ImageIcon soundIcon = new ImageIcon("C:/Users/erl/Pictures/instaIcon.jpg");
		JButton button = new JButton();
		if(soundIcon != null) {
			button.setIcon(soundIcon);
		}else {
			button.setText("BEEP~!");
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			Toolkit.getDefaultToolkit().beep();
			}
		});
		StyleConstants.setComponent(s, button);
		}
		
		public static void main(String[] args) {
			new JTextPaneEx();
		}
	}

