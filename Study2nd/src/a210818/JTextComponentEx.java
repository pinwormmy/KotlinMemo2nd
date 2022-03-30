package a210818;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.*;

public class JTextComponentEx extends JFrame{
	
	public JTextComponentEx() {
		
		super("JTextComponent Test");
		
		JPanel panel1 = new JPanel();
		JTextField field = new JTextField(5);
		
		class NumberDocument extends PlainDocument{
			public void insertString(int offset, String value, AttributeSet a) throws BadLocationException{
				char[] valueArr = value.toCharArray();
				for(int i=0; i<valueArr.length; i++) {
					if(!Character.isDigit(valueArr[i])) {
						getToolkit().beep();
						return;
					}
				}
				
				super.insertString(offset, value, a);
			}
		}
		
		JTextField numberField = new JTextField(2);
		numberField.setDocument(new NumberDocument());
		
		JPasswordField passField = new JPasswordField(5);
		
		panel1.add(new JLabel("Name : "));
		panel1.add(field);
		panel1.add(new JLabel("Age : "));
		panel1.add(numberField);
		panel1.add(new JLabel("Password : "));
		panel1.add(passField);
		
		JPanel panel2 = new JPanel(new BorderLayout());
		JTextArea textArea = new JTextArea(5, 10);
		textArea.setLineWrap(true);
		JScrollPane tscroll = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel2.add("North", new JLabel("자기소개"));
		panel2.add("Center", tscroll);
		
		add("North", panel1);
		add("Center", panel2);
		
		pack();
		setLocation(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTextComponentEx();
	}

}
