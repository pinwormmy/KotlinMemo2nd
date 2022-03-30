package a210817;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPaneEx extends JFrame{
	
	JSplitPane splitPane, splitPane1;
	
	public JSplitPaneEx() {
		super("SplitPaneEx Test");
		
		JTextArea jta1 = new JTextArea(20,10);
		JScrollPane jta1ScrollPane = new JScrollPane(jta1);
		
		JTextArea jta2 = new JTextArea(20,10);
		JScrollPane jta2ScrollPane = new JScrollPane(jta2);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jta1ScrollPane, jta2ScrollPane);
		
		JTextArea jta3 = new JTextArea(20,10);
		JScrollPane jta3ScrollPane = new JScrollPane(jta3);
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane, jta3ScrollPane);
		
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(100);
		splitPane.setPreferredSize(new Dimension(200,200));
		splitPane.setPreferredSize(new Dimension(400,200));
		
		add(splitPane1);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JSplitPaneEx();
	}

}
